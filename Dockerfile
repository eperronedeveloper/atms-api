FROM eclipse-temurin:21-jdk-alpine

RUN apk update && \
    apk add --no-cache maven

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

EXPOSE 8080

# ← Línea corregida: nombre exacto del JAR
CMD ["java", "-jar", "/app/target/atms-service-1.0.0.jar"]