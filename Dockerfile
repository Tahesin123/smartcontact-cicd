FROM openjdk:19
WORKDIR /usr/src
COPY . /usr/src
ADD target/smartcontactmanager-0.0.1-SNAPSHOT.jar smartcontactmanager-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "smartcontactmanager-0.0.1-SNAPSHOT.jar"]
