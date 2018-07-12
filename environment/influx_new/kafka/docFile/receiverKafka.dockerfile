FROM java:8-jdk
MAINTAINER Marcelo Alves
RUN mkdir /opt/flex/
WORKDIR /opt/flex/
COPY ./test-mq-time-series /opt/flex/
EXPOSE 8161 61616