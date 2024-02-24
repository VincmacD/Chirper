FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} messaging-service.jar
ENTRYPOINT ["java", "-jar", "/messaging-service.jar"]
EXPOSE 8082