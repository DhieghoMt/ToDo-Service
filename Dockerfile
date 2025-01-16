# Etapa 1: Construcción de la aplicación
# Utiliza una imagen base ligera de OpenJDK 17 con soporte para JDK
FROM openjdk:17-jdk-slim AS build

# Establece el directorio de trabajo en el contenedor a /app
WORKDIR /app

# Copia todo el contenido del directorio actual (donde está el Dockerfile) al directorio de trabajo del contenedor
COPY . .

# Cambia los permisos del archivo gradlew para hacerlo ejecutable
RUN chmod +x ./gradlew

# Ejecuta el comando para limpiar y construir el proyecto utilizando Gradle
# La opción `-x test` omite la ejecución de pruebas para ahorrar tiempo en la construcción
RUN ./gradlew clean build -x test



# Etapa 2: Generación de la imagen final
# Utiliza nuevamente la imagen ligera de OpenJDK 17 para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor a /app
WORKDIR /app

# Copia el archivo JAR generado en la etapa de construcción al contenedor en la etapa final
# Aquí se especifica que el archivo proviene del directorio `/app/build/libs/` generado en la etapa `build`
COPY --from=build /app/build/libs/ToDoApp-0.0.1-SNAPSHOT.jar app_todo.jar

# Expone el puerto 8080 para permitir el acceso a la aplicación desde el exterior
EXPOSE 8080

# Define el comando de inicio del contenedor: ejecuta el archivo JAR con Java
ENTRYPOINT ["java", "-jar", "app_todo.jar"]
