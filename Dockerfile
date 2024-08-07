FROM maven:3.9.8-amazoncorretto-21-al2023 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn spring-boot:run

EXPOSE 8080


CMD ["tail", "-f", "/dev/null"]