# ATMs Microservice

Microservicio RESTful en **Java 21 + Spring Boot 3** para gestionar cajeros automáticos (ATMs) en Argentina.

Endpoints disponibles:
- `GET /api/atms/list` → Lista paginada de todos los cajeros
- `GET /api/atms/{atmId}` → Detalle de un cajero por ID
- `GET /api/atms/search` → Búsqueda avanzada con filtros (banco, localidad, código postal, 24h, búsqueda libre, estado)

Conexión real a base MySQL en Aiven, paginación, respuestas envueltas (status, message, description, data), manejo global de errores y documentación OpenAPI/Swagger.

## Tecnologías

- Java 21
- Spring Boot 3.1
- Spring Data JPA + Hibernate
- MySQL (Aiven)
- OpenAPI 3 / Swagger UI
- HikariCP (pool de conexiones)

## Requisitos

- Java 21 (Eclipse Temurin o similar)
- Maven
- Base MySQL (Aiven o local)
- Certificado Aiven (`aiven-ca.pem`) para conexión SSL

## Configuración rápida (local)

1. Clonar el repo:
   ```bash
   git clone https://github.com/eperronedeveloper/atms-api.git
   cd atms-api
