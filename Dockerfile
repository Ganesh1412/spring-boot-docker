FROM openjdk:8-jdk-alpine
RUN "pwd"
ADD build/libs/spring-boot-docker-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
