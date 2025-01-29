FROM openjdk:21-jdk-slim
WORKDIR /app

# Install MySQL client (needed for debugging inside the container)
RUN apt update && apt install -y default-mysql-client

COPY src/main/resources /app/resources
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
