FROM gradle:8.12.1-jdk17-jammy AS build
WORKDIR /app

COPY build.gradle settings.gradle /app/
RUN gradle dependencies --no-daemon

COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar --no-daemon


FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/build/libs/*.jar party.jar

ENTRYPOINT ["java", "-jar", "/app/party.jar"]
EXPOSE 8081