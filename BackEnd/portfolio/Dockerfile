# Use a base JDK image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy JAR file from target folder
COPY target/*.jar app.jar

# Expose port (Spring Boot runs on 8080)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]