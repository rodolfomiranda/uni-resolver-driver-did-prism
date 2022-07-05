# Dockerfile for rodolfomiranda/driver-did-prism

FROM maven:3-jdk-11 AS build
LABEL Rodolfo Miranda <rodolfo.miranda@rootsid.com>

# build driver-did-prism

# ENV PRISM_SDK_PASSWORD=
# ENV PRISM_SDK_USER=
# ENV GITHUB_USER=
# ENV GITHUB_TOKEN=
# ENV PRISM_NODE_HOST="ppp-node-test.atalaprism.io"
# ENV PRISM_NODE_PORT=50053

ADD . /opt/driver-did-prism
RUN cd /opt/driver-did-prism && mvn clean install package -P war -N -DskipTests -s settings.xml

FROM jetty:9.4-jre11-slim

# variables

# copy from build stage
COPY --from=build --chown=jetty /opt/driver-did-prism/target/*.war /var/lib/jetty/webapps/ROOT.war

#done

EXPOSE 8080

CMD java -Djetty.http.port=8080 -Dorg.eclipse.jetty.annotations.maxWait=240 -jar /usr/local/jetty/start.jar
