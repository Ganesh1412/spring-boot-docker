FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN echo ${JAR_FILE}
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar",$JAR_FILE]
