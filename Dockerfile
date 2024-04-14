FROM openjdk:17-alpine
EXPOSE 8181
COPY ./target/*.jar FoyerApplication.jar
ENTRYPOINT [ "java", "-jar", "FoyerApplication.jar" ]
