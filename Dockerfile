FROM openjdk:21-ea-3-slim

ADD . /app

WORKDIR /app

COPY build/libs/rotina.0.1-SNAPSHOT.jar /app/rotina.jar

EXPOSE 9090

RUN rm -f /etc/localtime && ln -s /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime

ENTRYPOINT ["java", "-Xms1G", "-Xmx2G", "-XX:+UnlockExperimentalVMOptions", "-jar","/app/rotina.jar"]