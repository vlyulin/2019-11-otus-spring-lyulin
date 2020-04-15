FROM openjdk:11-jre-slim
COPY /target/library-spring-docker-0.0.1.jar /app/library-spring-docker-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/library-spring-docker-0.0.1.jar"]
