
FROM openjdk:17-alpine
EXPOSE 9090
ADD ./target/*.jar FoyerApplication.jar
ENTRYPOINT [ "java", "-jar", "./FoyerApplication.jar" ]
