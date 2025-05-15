FROM openjdk:11-jre-slim
COPY target/ticketing-service-1.0.0.jar /app/ticketing-service.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "/app/ticketing-service.jar"]
