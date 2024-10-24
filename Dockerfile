FROM docker.io/library/openjdk:21-jdk
ARG JAR_FILE=target/*.jar
RUN ls
RUN echo $JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=cloud","-jar","/app.jar"]