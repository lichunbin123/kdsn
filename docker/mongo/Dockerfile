FROM mongo:3.2.17-jessie
LABEL author="stan"
RUN apt-get install -f -y

COPY start.sh /start.sh
COPY mongoconfig /mongoconfig

RUN chmod 777 /start.sh
RUN chmod 777 /mongoconfig

ENTRYPOINT [ "/start.sh" ]
