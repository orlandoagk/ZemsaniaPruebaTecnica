FROM ubuntu:latest
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get upgrade
RUN apt-get install -y git
RUN apt-get install -y openjdk-8-jdk openjdk-8-jre
RUN apt-get install -y maven
RUN git clone https://github.com/orlandoagk/ZemsaniaPruebaTecnica.git
WORKDIR ZemsaniaPruebaTecnica
RUN mvn compile
RUN mvn clean package
CMD ["java","-cp","target/classes:target/dependency/*","com.zemsania.pruebatecnica.carrodecompra.CarrodecompraApplication"]