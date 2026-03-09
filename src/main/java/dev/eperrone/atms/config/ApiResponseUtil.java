package dev.eperrone.atms.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponseUtil {

    // Mapa estático con todos los códigos HTTP + mensaje + descripción (igual que tu Service.errors)
    private static final Map<Integer, Map<String, String>> HTTP_CODES = new HashMap<>();

    static {
        // 1xx Informacionales
        putCode(100, "Continuar", "El cliente debe continuar con la solicitud.");
        putCode(101, "Cambiando Protocolos", "El servidor acepta cambiar al protocolo especificado.");
        // ... podés copiar todos los que tenés en Express
        // 2xx Éxito
        putCode(200, "OK", "La solicitud ha sido exitosa.");
        putCode(201, "Creado", "La solicitud ha sido completada y se ha creado un nuevo recurso.");
        putCode(204, "Sin Contenido", "La solicitud ha sido exitosa, pero no hay contenido que enviar.");
        // 3xx Redirecciones
        putCode(301, "Movido Permanentemente", "El recurso solicitado se ha movido de manera permanente.");
        // 4xx Errores del cliente
        putCode(400, "Solicitud Incorrecta", "El servidor no puede o no procesará la solicitud debido a un error del cliente.");
        putCode(401, "No Autorizado", "La solicitud requiere autenticación del usuario.");
        putCode(403, "Prohibido", "El servidor entiende la solicitud pero se niega a autorizarla.");
        putCode(404, "No Encontrado", "El servidor no puede encontrar el recurso solicitado.");
        putCode(429, "Demasiadas Solicitudes", "El cliente ha enviado demasiadas solicitudes en un periodo de tiempo corto.");
        // 5xx Errores del servidor
        putCode(500, "Error Interno del Servidor", "El servidor encontró una condición inesperada que le impide completar la solicitud.");
        // Agregá los que faltan...
    }

    private static void putCode(int code, String message, String description) {
        Map<String, String> info = new HashMap<>();
        info.put("message", message);
        info.put("description", description);
        HTTP_CODES.put(code, info);
    }

    public static <T> ResponseEntity<Map<String, Object>> success(T payload, int code) {
        Map<String, String> info = HTTP_CODES.getOrDefault(code,
                Map.of("message", "Código desconocido", "description", "Descripción no disponible"));

        // LinkedHashMap para orden fijo
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", code);
        response.put("message", info.get("message"));
        response.put("description", info.get("description"));
        response.put("data", payload);

        return new ResponseEntity<>(response, HttpStatus.valueOf(code));
    }

    public static ResponseEntity<Map<String, Object>> error(String errorDetail, int code) {
        Map<String, String> info = HTTP_CODES.getOrDefault(code,
                Map.of("message", "Código desconocido", "description", "Descripción no disponible"));

        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("status", code);
        errorBody.put("message", info.get("message"));
        errorBody.put("description", info.get("description"));
        errorBody.put("error", errorDetail);

        return new ResponseEntity<>(errorBody, HttpStatus.valueOf(code));
    }

    // Helpers rápidos para los casos más comunes
    public static <T> ResponseEntity<Map<String, Object>> ok(T payload) {
        return success(payload, 200);
    }

    public static ResponseEntity<Map<String, Object>> notFound(String message) {
        return error(message, 404);
    }

    public static ResponseEntity<Map<String, Object>> badRequest(String message) {
        return error(message, 400);
    }

    public static ResponseEntity<Map<String, Object>> serverError(String message) {
        return error(message, 500);
    }
}