# Dockerfile for rodopincha/uni-resolver-driver-did-prism

FROM --platform=linux/amd64 maven:3-jdk-11 AS build
LABEL Rodolfo Miranda <rodolfo.miranda@rootsid.com>

# build driver-did-prism
ARG PRISM_SDK_USER
ARG PRISM_SDK_PASSWORD
ARG GITHUB_USER
ARG GITHUB_TOKEN

ENV PRISM_SDK_USER=${PRISM_SDK_USER}
ENV PRISM_SDK_PASSWORD=${PRISM_SDK_PASSWORD}
ENV GITHUB_USER=${GITHUB_USER}
ENV GITHUB_TOKEN=${GITHUB_TOKEN}

ADD . /opt/driver-did-prism
RUN cd /opt/driver-did-prism && mvn clean install package -P war -N -DskipTests -s settings.xml

FROM jetty:9.4-jre11-slim

# variables

ENV PRISM_NODE_HOST="ppp-node-test.atalaprism.io"
ENV PRISM_NODE_PORT=50053

# copy from build stage
COPY --from=build --chown=jetty /opt/driver-did-prism/target/*.war /var/lib/jetty/webapps/ROOT.war

#done

EXPOSE 8080

CMD java -Djetty.http.port=8080 -Dorg.eclipse.jetty.annotations.maxWait=240 -jar /usr/local/jetty/start.jar
