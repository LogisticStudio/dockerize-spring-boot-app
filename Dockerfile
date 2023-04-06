# Use an official Java runtime as a parent image
FROM adoptopenjdk/openjdk11:alpine-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Run Maven to build the application
RUN ./mvnw clean package

# Expose port 8080 for the container
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "target/my-spring-boot-app.jar"]
