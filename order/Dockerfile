From eclipse-temurin:21

WORKDIR /app

COPY target/order-0.0.1-SNAPSHOT.jar /app/order-docker.jar

ENTRYPOINT ["java","-jar","order-docker.jar"]