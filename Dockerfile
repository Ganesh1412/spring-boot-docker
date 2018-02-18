FROM openjdk:8-jdk-alpine
RUN "pwd"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/root/.jenkins/workspace/sample_job/build/libs/spring-boot-docker-0.1.0.jar"]
