FROM gradle:6.8.0-jdk11-openj9 AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN gradle build --no-daemon --info


FROM openjdk:11-jre-slim

COPY --from=build /home/gradle/src/build/libs/mvp.jar /app.jar

COPY docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh
ENTRYPOINT ["/docker-entrypoint.sh"]
