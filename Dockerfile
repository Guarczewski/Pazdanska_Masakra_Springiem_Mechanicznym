FROM openjdk:latest
COPY target/SpringWithSQL-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "SpringWithSQL-0.0.1-SNAPSHOT.jar"]