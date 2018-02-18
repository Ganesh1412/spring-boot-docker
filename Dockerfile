FROM openjdk:8-jdk-alpine
RUN "pwd"
RUN "find . -name "*.jar" -exec ls -lrt {} \;"
//ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","build/libs/spring-boot-docker-0.1.0.jar"]
