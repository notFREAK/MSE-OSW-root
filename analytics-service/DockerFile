FROM openjdk:17-jre-slim
COPY target/analytics-service.jar /app/analytics-service.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "/app/analytics-service.jar"]
