FROM openjdk:11

EXPOSE 8080

ADD /build/libs/*.jar /consulta-cep-api.jar

ENTRYPOINT ["java", "-jar", "/consulta-cep-api.jar"]