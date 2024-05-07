FROM openjdk:11-jdk-slim AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw package -DskipTests

FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
