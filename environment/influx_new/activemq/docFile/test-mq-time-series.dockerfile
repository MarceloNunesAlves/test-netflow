FROM flexvision/test-mq-time-series:1.0
MAINTAINER Marcelo Nunes
WORKDIR /opt/flex/test-mq-time-series/logs/
CMD /opt/flex/test-mq-time-series/bin/test-mq-time-series start && tail -f /dev/null