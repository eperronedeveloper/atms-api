package dev.eperrone.atms.repository;

import dev.eperrone.atms.model.ATM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATMRepository extends JpaRepository<ATM, Long> {
    // Puedes agregar métodos personalizados aquí si querés (ej: findByBank)
}