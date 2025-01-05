FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test



FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/ToDoApp-0.0.1-SNAPSHOT.jar app_todo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_todo.jar"]
