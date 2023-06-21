FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY build/libs/user-service-1.0.jar user-service.jar
ENTRYPOINT ["java","-Dspring.profiles.active=${USE_PROFILE}","-jar","/user-service.jar"]