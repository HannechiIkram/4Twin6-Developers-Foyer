FROM openjdk:17-alpine
WORKDIR /app
RUN apk --no-cache add curl
COPY target/FoyerApplication.jar /app/FoyerApplication.jar

EXPOSE 8181
ENTRYPOINT [ "java", "-jar", "./FoyerApplication.jar" ]
