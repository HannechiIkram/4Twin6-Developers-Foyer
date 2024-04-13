FROM openjdk:17-alpine
EXPOSE 8181

# Create a directory to hold the application JAR
WORKDIR /app

# Copy the JAR file from the build context into the image
COPY ./target/*.jar FoyerApplication.jar

ENTRYPOINT ["java", "-jar", "FoyerApplication.jar"]
