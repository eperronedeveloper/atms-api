# Usa una imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Crea carpeta de trabajo
WORKDIR /app

# Copia el pom.xml y descarga dependencias (cachea esto para builds rápidos)
COPY pom.xml .
RUN apk add --no-cache maven && mvn dependency:go-offline

# Copia todo el código
COPY src ./src

# Construye el JAR
RUN mvn clean package -DskipTests

# Expone el puerto de Spring Boot (por default 8080)
EXPOSE 8080

# Comando para correr la app
CMD ["java", "-jar", "target/*.jar"]