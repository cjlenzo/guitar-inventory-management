FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/work-0.0.1.jar work.jar
ENTRYPOINT ["java", "-jar", "work.jar"]