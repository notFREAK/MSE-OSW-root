FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/eureka-server-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app.jar"]
