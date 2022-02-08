FROM adoptopenjdk:jdk

RUN apt update && apt install -y netcat && apt clean
RUN mkdir /opt/leo-database-learner
COPY target/*.jar /opt/leo-database-learner
COPY scripts/* /opt/leo-database-learner
RUN sed -e 's/\r$//' -i /opt/leo-database-learner/*.sh && chmod +x /opt/leo-database-learner/*.sh

EXPOSE 8080
WORKDIR /opt/leo-database-learner
ENTRYPOINT ["./run.sh"]
