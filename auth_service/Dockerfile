# Dockerfile для auth_service
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/auth_service-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]