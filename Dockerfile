# Use the official OpenJDK base image
FROM openjdk:17-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/Foyer-0.0.1.jar /app/Foyer.jar

# Expose the port that your application listens on
EXPOSE 8181

# Run the JAR file
CMD ["java", "-jar", "Foyer.jar"]

