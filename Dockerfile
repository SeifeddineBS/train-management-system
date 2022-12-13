FROM openjdk:11
EXPOSE 8083
ADD target/validation.jar validation.jar
ENTRYPOINT ["java","-jar","/validation.jar"]
