FROM openjdk:11

EXPOSE 8080

ADD /build/libs/*.jar /app/consulta-cep-api.jar

ENTRYPOINT ["java", "-jar", "/app/consulta-cep-api.jar"]