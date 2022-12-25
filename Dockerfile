FROM: openjdk
WORKDIR /usr/src/smart
COPY . /usr/src/smart
ADD target/smartcontactmanager-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "smartcontactmanager-0.0.1-SNAPSHOT.jar"]
