FROM java:8-jre
MAINTAINER  Sashi Kumar Singh <sashi18singh@gmail.com>
COPY ./target/UpstreamService-0.0.1-SNAPSHOT.jar /usr/app/src/UpstreamService-0.0.1-SNAPSHOT.jar
WORKDIR /usr/app/src
ENTRYPOINT ["java","-jar", "UpstreamService-0.0.1-SNAPSHOT.jar"]
