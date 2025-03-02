# Use a Maven image to build the project
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory inside the container
WORKDIR /app

# Copy the pom.xml separately (to take advantage of Docker caching)
COPY BackEnd/portfolio/pom.xml .

# Download dependencies (this speeds up the build process)
RUN mvn dependency:go-offline -B

# Now copy the entire project
COPY BackEnd/portfolio/ .

# Build the project
RUN mvn clean package -DskipTests

# Use a lightweight JDK to run the app
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]