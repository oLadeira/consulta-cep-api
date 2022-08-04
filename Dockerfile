FROM openjdk:11

EXPOSE 8080

ARG JAR_FILE=/build/libs/*.jar

COPY ${JAR_FILE} consulta-cep-api.jar

RUN bash -c 'touch /consulta-cep-api.jar'

# ADD /build/libs/*.jar /consulta-cep-api.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/consulta-cep-api.jar"]