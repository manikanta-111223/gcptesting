FROM maven:3.8.1-jdk-8-slim AS build

WORKDIR /opt/app

COPY src src

COPY pom.xml .

RUN mvn -f pom.xml clean install -Dmaven.test.skip=true

FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/AKCBreedsProject-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

EXPOSE 8080

COPY --from=build /opt/app/${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]