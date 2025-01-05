# Usar una imagen base de JDK para la construcción
FROM openjdk:17-jdk-slim AS build
WORKDIR /app

# Copiar el proyecto completo al contenedor
COPY . /app

# Construir el JAR
RUN ./gradlew build || ./mvnw package

# Imagen final para ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar solo el JAR desde la etapa de construcción
COPY --from=build /app/build/libs/ToDoApp-0.0.1-SNAPSHOT.jar app_todo.jar

# Exponer el puerto y definir el comando de ejecución
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_todo.jar"]
