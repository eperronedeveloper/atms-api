FROM eclipse-temurin:21-jdk-alpine

RUN apk update && \
    apk add --no-cache maven

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

EXPOSE 8080

ENV PORT=8080
ENV RAILWAY_RUN_UID=0

CMD ["java", "-jar", "/app/target/atms-service-1.0.0.jar"]