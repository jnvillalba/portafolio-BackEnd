FROM amazoncorretto:11-alpine-jdk
MAINTAINER jnvillalba
COPY target/jnv-0.0.1-SNAPSHOT.jar  jnv-backend.jar
ENTRYPOINT ["java","-jar","/jnv-backend.jar"]