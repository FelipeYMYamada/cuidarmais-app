FROM openjdk:17-alpine
VOLUME /app
COPY . /app
WORKDIR /app
RUN chmod +x mvnw
RUN ./mvnw clean install
ENTRYPOINT ["java","-jar","/app/target/cuidarmais-app-0.0.1-SNAPSHOT.jar"]