# Dockerfile для inspection_service
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/inspection_service-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]