# Dockerfile для Content Management Service
FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/content-service-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "/app.jar"]
