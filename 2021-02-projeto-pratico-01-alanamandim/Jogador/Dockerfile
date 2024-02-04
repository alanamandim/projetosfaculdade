FROM openjdk:11

WORKDIR /src

COPY . /src

RUN ./gradlew jar
ENTRYPOINT  [ "java","-cp","build/libs/Jogador-1.0-SNAPSHOT.jar","jogador.Jogador"]
