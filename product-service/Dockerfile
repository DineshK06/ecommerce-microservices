FROM openjdk:21-jdk-slim
LABEL authors="dineshkumar"
WORKDIR /app

COPY src/main/resources /app/resources
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
