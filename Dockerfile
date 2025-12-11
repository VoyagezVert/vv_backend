FROM gradle:9-jdk25-corretto as builder
WORKDIR /app
COPY . .
RUN gradle clean build
RUN gradle clean bootJar

FROM eclipse-temurin:25-alpine-3.22 as prod
COPY --from=builder /app/build/libs/vv_backend-0.0.1-SNAPSHOT.jar /home/vv_backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/vv_backend.jar"]