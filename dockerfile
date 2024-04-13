FROM openjdk:17-alpine
WORKDIR /app
RUN apk --no-cache add curl

EXPOSE 8181
ENTRYPOINT [ "java", "-jar", "./FoyerApplication.jar" ]
