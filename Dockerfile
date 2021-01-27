FROM openjdk:8-alpine
WORKDIR /usr/app
COPY build/libs/tripPricer-1.0.0.jar tourguide-trip-pricer.jar
CMD ["java", "-jar", "tourguide-trip-pricer.jar"]