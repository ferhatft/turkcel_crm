FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . /app/

RUN mvn clean package -DskipTests



FROM openjdk:17-jdk
COPY --from=build /app/target/productservice-0.0.1-SNAPSHOT.jar /app/productservice.jar
CMD java -jar /app/productservice.jar
