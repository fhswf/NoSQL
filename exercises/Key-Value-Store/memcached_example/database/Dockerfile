FROM mysql:8.4.0

RUN chown -R mysql:root /var/lib/mysql/

ENV MYSQL_DATABASE=example
ENV MYSQL_ROOT_PASSWORD=secret

ADD ./data.sql /etc/mysql/data.sql

RUN sed -i 's/MYSQL_DATABASE/'$MYSQL_DATABASE'/g' /etc/mysql/data.sql
RUN cp /etc/mysql/data.sql /docker-entrypoint-initdb.d

EXPOSE 3306