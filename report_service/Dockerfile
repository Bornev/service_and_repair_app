# Dockerfile для report_service
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/report_service-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]