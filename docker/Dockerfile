# Alpine Linux com OpenJDK 11 JRE
FROM azul/zulu-openjdk-alpine:11

# Copiar pacote .jar e renomear para echo.war
COPY todo-0.0.1-SNAPSHOT.jar /echo.war

# Executar a aplicação
CMD ["/usr/bin/java", "-jar", "/echo.war"]