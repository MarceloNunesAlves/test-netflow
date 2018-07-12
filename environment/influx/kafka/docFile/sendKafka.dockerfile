FROM spotify/kafka
MAINTAINER Marcelo Alves
RUN mkdir /opt/flex/
WORKDIR /opt/flex/
COPY ./test-mq-time-series /opt/flex/
EXPOSE 2181 9092