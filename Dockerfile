FROM maven:3.8.6-eclipse-temurin-19-focal

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

COPY src ./src
RUN mvn clean install -U

CMD ["java", "-jar", "./target/api-0.0.1-SNAPSHOT.jar"]
