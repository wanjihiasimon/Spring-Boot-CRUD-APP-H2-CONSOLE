# -------- BUILD STAGE --------
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom and resolve dependencies early for caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Package the app (skip test execution)
RUN mvn clean package -DskipTests

# -------- RUNTIME STAGE --------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/KCB_Branch_API_H2-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
