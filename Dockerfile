FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.13_8_openj9-0.29.0-alpine-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /poc-cors-0.0.1.jar
EXPOSE 8080:8080
ENTRYPOINT ["java","-jar","/poc-cors-0.0.1.jar"]
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar /poc-cors-0.0.1.jar