FROM openjdk:19
COPY target/smartcontactmanager-0.0.1-SNAPSHOT.jar smartcontactmanager-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "smartcontactmanager-0.0.1-SNAPSHOT.jar"]
