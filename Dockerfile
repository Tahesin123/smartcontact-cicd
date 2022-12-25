FROM openjdk:19
WORKDIR /usr/src
COPY . /usr/src
ADD smartcontactmanager-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "smartcontactmanager-0.0.1-SNAPSHOT.jar"]
