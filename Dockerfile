FROM maven:3.8.1-openjdk-11 as maven
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests
FROM openjdk:11
WORKDIR /test
COPY --from=maven target/securityApp-*.jar ./test/securityApp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./test/securityApp.jar"]