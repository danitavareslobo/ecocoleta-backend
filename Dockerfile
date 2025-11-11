# Multi-stage build for EcoColeta API

# Build stage
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /build

# Copy the entire Spring Boot project
COPY ecocoleta-api/ /build/

# Build the application
RUN ./mvnw clean install -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /build/target/ecocoleta.jar /app/app.jar

# Expose application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
