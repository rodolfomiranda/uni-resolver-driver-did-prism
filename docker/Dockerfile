# Dockerfile for rodolfomiranda/driver-did-prism

FROM maven:3-jdk-11 AS build
MAINTAINER Rodolfo Miranda <rodolfo.miranda@rootsid.com>

# build driver-did-prism



ADD . /opt/driver-did-prism
RUN cd /opt/driver-did-prism && mvn clean install package -P war -N -DskipTests --settings settings.xml
#RUN cd /opt/driver-did-prism && mvn install package -P war -N -DskipTests --settings settings.xml


FROM jetty:9.4-jre11-slim

# variables

ENV PRISM_NODE_HOST="ppp-node-test.atalaprism.io"
ENV PRISM_NODE_PORT=50053

ENV uniresolver_driver_did_btcr_bitcoinConnection=blockcypherapi
ENV uniresolver_driver_did_btcr_rpcUrlMainnet=http://user:pass@localhost:8332/
ENV uniresolver_driver_did_btcr_rpcUrlTestnet=http://user:pass@localhost:18332/
ENV uniresolver_driver_did_btcr_rpcCertMainnet=
ENV uniresolver_driver_did_btcr_rpcCertTestnet=

# copy from build stage
COPY --from=build --chown=jetty /opt/driver-did-prism/target/*.war /var/lib/jetty/webapps/ROOT.war

#done

EXPOSE 8080

CMD java -Djetty.http.port=8080 -Dorg.eclipse.jetty.annotations.maxWait=240 -jar /usr/local/jetty/start.jar
