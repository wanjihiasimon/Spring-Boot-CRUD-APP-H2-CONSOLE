# -------- BUILD STAGE --------
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom and resolve dependencies for better caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application without compiling or running tests
RUN mvn clean package -Dmaven.test.skip=true

# -------- RUNTIME STAGE --------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/KCB_Branch_API_H2-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
