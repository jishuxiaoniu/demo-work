FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD demo-work-0.0.1-SNAPSHOT-dev.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]