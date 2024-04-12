
FROM openjdk:17-alpine
EXPOSE 8181
ADD ./target/*.jar FoyerApplication.jar
ENTRYPOINT [ "java", "-jar", "./FoyerApplication.jar" ]