# Imagen base con Java 21 (Alpine es liviana)
FROM eclipse-temurin:21-jdk-alpine

# Instala Maven manualmente (porque la imagen base no lo trae)
RUN apk update && \
    apk add --no-cache maven

# Crea carpeta de trabajo
WORKDIR /app

# Copia pom.xml primero (para cachear dependencias)
COPY pom.xml .

# Descarga dependencias (esto se cachea y acelera builds posteriores)
RUN mvn dependency:go-offline

# Copia todo el código fuente
COPY src ./src

# Construye el JAR
RUN mvn clean package -DskipTests

# Expone el puerto
EXPOSE 8080

# Comando para correr la app
CMD ["java", "-jar", "target/*.jar"]