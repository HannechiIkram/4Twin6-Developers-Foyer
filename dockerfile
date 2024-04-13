FROM openjdk:17-alpine
EXPOSE 8181

# Copy the JAR file from the target directory into the Docker image
COPY ./src/target/*.jar /app/FoyerApplication.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "FoyerApplication.jar"]
