FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=build/libs/order-micro.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]