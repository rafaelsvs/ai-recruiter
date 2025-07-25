FROM openjdk:17-slim

WORKDIR /app

# Ajuste o caminho do JAR conforme o módulo que gera o Spring Boot final
ARG JAR_FILE=ai-recruiter-app/target/ai-recruiter-app-1.0.0.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080 5005

ENTRYPOINT ["java", "-jar", "/app/app.jar"]