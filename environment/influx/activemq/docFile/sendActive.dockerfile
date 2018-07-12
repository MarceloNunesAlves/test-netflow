FROM flexvision/send-msg-activemq:1.0
MAINTAINER Marcelo Nunes
WORKDIR /opt/flex/test-mq-time-series/logs/
CMD /opt/flex/test-mq-time-series/bin/test-mq-time-series start && /app/run.sh