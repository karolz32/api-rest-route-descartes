FROM adoptopenjdk/openjdk11:alpine
COPY target/api-rotas-0.0.1-SNAPSHOT.jar api-rotas.jar
ENTRYPOINT ["java","-jar","/api-rotas.jar"]