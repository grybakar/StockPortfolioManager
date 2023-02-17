FROM amazoncorretto:17-alpine-jdk
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
ENV DATABASE_HOST=postgreSqlContainer
ENV DATABASE_PORT=5432