FROM openjdk:8

ADD target/restfull-1.war restfull.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "restfull.jar"]

