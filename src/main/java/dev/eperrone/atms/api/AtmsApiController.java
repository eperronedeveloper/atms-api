package dev.eperrone.atms.api;

import dev.eperrone.atms.config.ApiResponseUtil;
import dev.eperrone.atms.model.ATM;
import dev.eperrone.atms.model.Pagination;
import dev.eperrone.atms.model.SearchATMs200Response;
import dev.eperrone.atms.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/atms")
public class AtmsApiController {

    @Autowired
    private ATMRepository atmRepository;

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> listATMs(
            @RequestParam(defaultValue = "0") Integer offset,
            @RequestParam(defaultValue = "10") Integer limit) {

        List<ATM> allAtms = atmRepository.findAll();

        int start = Math.max(0, offset != null ? offset : 0);
        int end = Math.min(start + (limit != null ? limit : 10), allAtms.size());

        List<ATM> paginated = allAtms.subList(start, end);

        SearchATMs200Response response = new SearchATMs200Response();

        Pagination pagination = new Pagination();
        pagination.setTotalItems(allAtms.size());
        pagination.setOffset(start);
        pagination.setLimit(end - start);

        response.setPagination(pagination);
        response.setAtms(paginated);

        return ApiResponseUtil.success(response, 200);
    }

    @GetMapping("/{atmId}")
    public ResponseEntity<Map<String, Object>> getATMById(@PathVariable Long atmId) {
        return atmRepository.findById(atmId)
                .map(atm -> ApiResponseUtil.success(atm, 200))
                .orElseGet(() -> ApiResponseUtil.error("Cajero con ID " + atmId + " no encontrado", 404));
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchATMs(
            @RequestParam(defaultValue = "0") Integer offset,
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(required = false) String bank,
            @RequestParam(required = false) Integer localityId,
            @RequestParam(required = false) String postalCode,
            @RequestParam(required = false) Boolean has24h,
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String status) {

        List<ATM> allAtms = atmRepository.findAll();

        List<ATM> filtered = allAtms.stream()
                .filter(atm -> bank == null || atm.getBank().equalsIgnoreCase(bank))
                .filter(atm -> localityId == null || (atm.getLocalityId() != null && atm.getLocalityId().equals(localityId)))
                .filter(atm -> postalCode == null || (atm.getPostalCode() != null && atm.getPostalCode().contains(postalCode)))
                .filter(atm -> has24h == null || atm.getHas24h().equals(has24h))
                .filter(atm -> q == null ||
                        (atm.getAddress() != null && atm.getAddress().toLowerCase().contains(q.toLowerCase())) ||
                        (atm.getBank() != null && atm.getBank().toLowerCase().contains(q.toLowerCase())))
                .filter(atm -> status == null || atm.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());

        int start = Math.max(0, offset != null ? offset : 0);
        int end = Math.min(start + (limit != null ? limit : 10), filtered.size());

        List<ATM> paginated = filtered.subList(start, end);

        SearchATMs200Response response = new SearchATMs200Response();

        Pagination pagination = new Pagination();
        pagination.setTotalItems(filtered.size());
        pagination.setOffset(start);
        pagination.setLimit(end - start);

        response.setPagination(pagination);
        response.setAtms(paginated);

        return ApiResponseUtil.success(response, 200);
    }
}