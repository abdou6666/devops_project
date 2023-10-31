FROM openjdk:8
EXPOSE 8080
ADD target/achat-1.0.jar achat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]