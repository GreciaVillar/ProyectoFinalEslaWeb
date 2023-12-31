# Stage 1: Build
FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

WORKDIR /app
COPY . .

RUN mvn clean install

# Stage 2: Runtime
FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/target/Proyecto_Final_ESLA-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

#Ajustar configuración