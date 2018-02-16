FROM openjdk:8-jdk-alpine
RUN ./gradlew clean build
