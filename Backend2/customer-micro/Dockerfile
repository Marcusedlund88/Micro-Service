FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=build/libs/customer-micro.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]