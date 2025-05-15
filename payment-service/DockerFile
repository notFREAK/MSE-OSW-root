# Dockerfile для Public Event Service
FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/payment-service-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app.jar"]
