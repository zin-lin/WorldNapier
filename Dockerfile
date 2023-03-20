FROM openjdk:latest
COPY ./target/WorldNapier.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "WorldNapier.jar", "db:3306", "30000"]