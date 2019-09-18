FROM openjdk:8-jdk-alpine
RUN "pwd"
ADD target/gs-spring-boot-docker-0.1.0-spring-boot.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
