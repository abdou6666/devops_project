FROM openjdk:8-jdk-alpine

WORKDIR /app
EXPOSE 8089
COPY ./target/achat-1.0.jar /app

CMD ["java", "-jar", "achat-1.0.jar"]