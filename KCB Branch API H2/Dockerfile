# -------- BUILD STAGE --------
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom and download dependencies (caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the JAR (skip tests execution but compile them)
RUN mvn clean package -DskipTests

# -------- RUNTIME STAGE --------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the built JAR (use wildcard to avoid hardcoding version)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
