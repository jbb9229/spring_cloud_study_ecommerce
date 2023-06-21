FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY build/libs/gateway-service-1.0.jar gateway-service.jar
ENTRYPOINT ["java","-Dspring.profiles.active=${USE_PROFILE}","-jar","/gateway-service.jar"]