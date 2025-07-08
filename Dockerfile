FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-participantes-1.0.2.jar app.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "app.jar"]