From eclipse-temurin:21

WORKDIR /app

COPY target/userInfo-0.0.1-SNAPSHOT.jar /app/userInfo-docker.jar
ENTRYPOINT ["java","-jar","userInfo-docker.jar"]