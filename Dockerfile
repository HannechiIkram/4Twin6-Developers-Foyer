FROM openjdk:17-alpine
RUN adduser -D myuser

USER myuser
EXPOSE 8181
ADD ./target/*.jar FoyerApplication.jar
ENTRYPOINT [ "java", "-jar", "./FoyerApplication.jar" ]

