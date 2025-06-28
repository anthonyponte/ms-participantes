FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-participantes-1.0.1.jar app.jar
EXPOSE 7075
ENTRYPOINT ["java", "-jar", "app.jar"]