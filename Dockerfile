FROM openjdk:21

WORKDIR /app

COPY . /app

RUN ./mvnw -B clean package

EXPOSE 8085

CMD ["java", "-jar", "target/apiFuncionarios-0.0.1-SNAPSHOT.jar"]