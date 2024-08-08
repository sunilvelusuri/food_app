From eclipse-temurin:21

WORKDIR /app

#COPY target/restaurantListing-0.0.1-SNAPSHOT.jar /app/restaurantListing.jar
#ENTRYPOINT ["java","-jar","restaurantlisting.jar"]



COPY target/restaurantListing-0.0.1-SNAPSHOT.jar /app/restaurantListing-docker.jar

ENTRYPOINT ["java","-jar","restaurantListing-docker.jar"]


