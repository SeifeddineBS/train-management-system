FROM openjdk:11
EXPOSE 8083
ADD target/examen-1.0.jar examen-1.0.jar
ENTRYPOINT ["java","-jar","/examen-1.0.jar"]
