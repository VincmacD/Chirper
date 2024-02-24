FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-management-service.jar
ENTRYPOINT ["java", "-jar", "/user-management-service.jar"]
EXPOSE 8081