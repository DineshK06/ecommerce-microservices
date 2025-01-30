FROM openjdk:21-jdk-slim
LABEL authors="dineshkumar"
WORKDIR /app

COPY build/libs/payment-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
