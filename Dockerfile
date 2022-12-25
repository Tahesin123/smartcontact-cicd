FROM openjdk:19
WORKDIR /usr/src/smart
COPY . /usr/src/smart
CMD ["java", "-jar", "smartcontactmanager-0.0.1-SNAPSHOT.jar"]
