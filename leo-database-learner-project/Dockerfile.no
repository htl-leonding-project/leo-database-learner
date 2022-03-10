FROM maven:3.8.3-openjdk-16-slim as build

WORKDIR /app/

COPY pom.xml ./

RUN mvn clean install

COPY . .

RUN mvn -Dquarkus.package.type=uber-jar -DskipTests verify

FROM openjdk:11.0.13-jre-slim

COPY --from=build /app/target/*-runner.jar application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]
