# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-focal

ARG LOCAL_USER_NAME=docker
ARG LOCAL_USER_ID=1000
ARG LOCAL_GROUP_ID=1000

RUN useradd \
    -m ${LOCAL_USER_NAME} \
    --uid=${LOCAL_USER_ID}

USER $USER

WORKDIR /app

CMD ["./mvnw", "spring-boot:run"]
