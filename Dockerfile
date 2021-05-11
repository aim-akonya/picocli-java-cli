FROM openjdk:8-jdk-alpine
MAINTAINER aim-akonya
COPY target/PicocliCli.jar PicocliCli.jar
ENTRYPOINT ["java"]
CMD ["-XX:MinHeapFreeRatio=10", "-XX:MaxHeapFreeRatio=70", "-XX:CompressedClassSpaceSize=64m", "-XX:ReservedCodeCacheSize=64m", "-XX:MaxMetaspaceSize=256m", "-Xms256m", "-Xmx750m", "-jar", "/PicocliCli.jar"]
EXPOSE 8080
