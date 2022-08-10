FROM openjdk:11

EXPOSE 8080

ADD /build/libs/consulta-cep-api-0.0.1-SNAPSHOT.jar consulta-cep-api.jar

ENTRYPOINT ["java", "-jar", "consulta-cep-api.jar"]