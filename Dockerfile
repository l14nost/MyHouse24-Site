FROM openjdk:17
COPY target/MyHouse24-Site.jar myhouse24-site.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar", "myhouse24-site.jar"]