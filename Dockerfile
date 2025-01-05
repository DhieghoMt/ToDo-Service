FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . /app
RUN ./gradlew build || ./mvnw package
ARG JAR_FILE=build/libs/ToDoApp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_todo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_todo.jar"]
