FROM openjdk:11
EXPOSE 8083
ADD target/ExamThourayaS2.jar ExamThourayaS2.jar
ENTRYPOINT ["java","-jar","/ExamThourayaS2.jar"]
