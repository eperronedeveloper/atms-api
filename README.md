# ATMs Microservice

Microservicio RESTful en **Java 21 + Spring Boot 3** para gestionar cajeros automáticos (ATMs) en Argentina.

Permite:
- Listar cajeros paginados (`/api/atms/list`)
- Obtener detalle de un cajero por ID (`/api/atms/{id}`)
- (Próximamente) Búsqueda avanzada con filtros (`/api/atms/search`)

Conexión real a base MySQL en Aiven, con paginación, manejo de errores y documentación OpenAPI.

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
