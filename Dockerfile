# ---- build stage (Gradle + JDK17) ----
FROM gradle:8.7-jdk17-alpine AS build
WORKDIR /src
COPY . .
RUN gradle --no-daemon clean bootJar

# ---- runtime stage (JRE) ----
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/build/libs/*.jar app.jar
ENV JAVA_OPTS="-XX:+UseG1GC -XX:MaxRAMPercentage=75.0"
EXPOSE 8080
CMD ["sh","-c","java $JAVA_OPTS -jar app.jar"]