FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests


 
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build target/api_note-0.0.1-SNAPSHOT.jar api_note.jar
ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080
ENTRYPOINT ["java","-jar","api_note.jar"]