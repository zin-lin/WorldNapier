FROM openjdk:latest
COPY ./target/WorldNapier-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "WorldNapier.jar", "db:3306", "30000"]