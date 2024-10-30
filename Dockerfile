# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# The application's JAR file
ARG JAR_FILE=target/grocery-booking-api.jar

# Add the application's JAR file to the container
COPY ${JAR_FILE} app.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]