FROM openjdk:11
EXPOSE 8083
ADD target/examthourayas2.jar examthourayas2.jar
ENTRYPOINT ["java","-jar","/examthourayas2.jar"]
