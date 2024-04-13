FROM openjdk:17-alpine
WORKDIR /app
RUN apk --no-cache add curl
EXPOSE 8181
ADD ./target/*.jar FoyerApplication.jar
ENTRYPOINT [ "java", "-jar", "./FoyerApplication.jar" ]
