FROM openjdk:17-alpine

WORKDIR /app

COPY target/ms-find-car.jar app.jar

EXPOSE 8570

ENTRYPOINT [ "java", "-jar", "app.jar" ]