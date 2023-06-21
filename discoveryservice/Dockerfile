FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY build/libs/discoveryservice-1.0.jar discoveryservice.jar
ENTRYPOINT ["java","-Dspring.profiles.active=${USE_PROFILE}","-jar","/discoveryservice.jar"]