FROM openjdk:17
ENV TZ=Asia/Seoul
COPY build/libs/SearchServer-0.0.1.jar SearchServer.jar
ENTRYPOINT ["java", "-jar", "SearchServer.jar"]