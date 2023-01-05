FROM amazoncorretto:8-alpine-jdk

MAINTAINER jnvillalba

COPY target/jnv-0.0.1-SNAPSHOT.jar jnv-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/jnv-0.0.1-SNAPSHOT.jar"]