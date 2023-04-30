# Set the base image to OpenJDK 11 JRE slim
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the executable JAR file to the Docker image
COPY . /app/

# Expose the port that your application will be running on
EXPOSE 8080

# Use the CMD instruction to run the JAR file of your application
CMD ["java", "-jar", "/app/target/serverapi-0.0.1-SNAPSHOT.jar"]