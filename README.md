# P8-TOURGUIDE-TRIPPRICER
MICROSERVICE OF P8-TOURGUIDE

# P8-TOURGUIDE-GPSUTIL
MICROSERVICE OF P8-TOURGUIDE

## Purpose
TourGuide is a Spring Boot application that has been a centerpiece in the TripMasters app portfolio. 
The application will be targeting people looking for package deals on hotel stays and admissions to various attractions. 

It now supports the tracking of 100.000 users in a bit more than 3 minutes and the calculation of reward points for 100.000 users in +-8,5 minutes.
As it is now, TripMaster can even go up to 235.000 users, under the requirements of 15 and 20 minutes each set at the beginning of the project's construction (for tracking locations and rewards).

## Architecture Overview
Below, you can find the architecture Overview of TourGuide:

![Screenshot](ArchitectureOverView.PNG)

## Domain layer Overview
All the different fields are represented here-under on this diagram:

![Screenshot](UML_Diagram.png)

## Prerequisites to run
- Java 1.8 JDK
- Gradle 4.8.1
- Docker


## Installing
1. Install **Java**: https://www.oracle.com/java/technologies/javase-downloads.html

2. Install **Gradle**: https://gradle.org/install/

3. Install Docker Desktop:
https://docs.docker.com/docker-for-windows/ or https://docs.docker.com/docker-for-mac/

## Technical Specifications

TourGuide is composed of 4 microservices:
1. **TourGuide**
https://github.com/ALEXD2758/P8-TOURGUIDE.git
2. **Gps-Util**
https://github.com/ALEXD2758/P8-TOURGUIDE-GPSUTIL.git
3. **Rewards Central**
https://github.com/ALEXD2758/P8-TOURGUIDE-REWARS-CENTRAL.git
4. **Trip Pricer**
https://github.com/ALEXD2758/P8-TOURGUIDE-TRIPPRICER.git

## Run the application


- **WITH IDE/GRADLE**: Change the BASE_URL present in files GpsUtilWebClient/RewardsWebClient/TripPricerWebClient in folder src/main/java/tourGuide/webclient/ to: "http://localhost:+PORT". For running the application, either launch it in your IDE or run below command inside the root directory of the 4 microservices:
```
$ ./gradlew bootRun
```
- **WITH DOCKER**: Use this exact procedure: 
> 1. Build your application with gradle
```
$ ./gradlew build
```
> 2. Build docker images for each microservice. In each microservice root directory, launch the following command:

```
$ docker build -t NAME_OF_YOUR_IMAGE:TAGVERSION .
```
> 3. Go back into P8-TOURGUIDE root directory and launch this command, which is going to launch and compose the Docker containers from images previously created, but also run then.
You will then see all applications running with Spring Boot.

```
$ docker-compose up
```

**GOOD TO KNOW:** Compose is a tool for defining and running multi-container Docker applications. With Compose, you use a YAML file to configure your application's services. 
Then, with a single command, you create and start all the services from your configuration. ... 
Run docker-compose up and Compose starts and runs your entire app.

## Endpoint

> **GET** - Get a list of providers with trip deals
http://localhost:8081/getPrice" <br>
**OBLIGATORY parameters**: apiKey, attractionId, adults, children, nightsStay, rewardsPoints 

