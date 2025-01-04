FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/ToDoApp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_todo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_todo.jar"]
