FROM openjdk:17
COPY target/MyHouse24-Site.jar myhouse24-site.jar
ENTRYPOINT ["java","-jar", "myhouse24-site.jar"]