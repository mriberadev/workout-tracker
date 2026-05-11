FROM gradle:jdk26-alpine AS builder
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle clean build


FROM eclipse-temurin:26-alpine AS runner
WORKDIR /app
COPY --from=builder ./app/build/libs/*.jar ./app.jar

EXPOSE 4000

ENTRYPOINT ["java", "-jar", "app.jar"]