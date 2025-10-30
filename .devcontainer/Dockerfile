FROM gradle:9-jdk25-corretto

USER root

WORKDIR /workspace

# Installer Node.js + Commitizen
RUN curl -fsSL https://rpm.nodesource.com/setup_20.x | bash - \
    && yum install -y nodejs git \
    && npm install -g commitizen cz-conventional-changelog \
    && yum clean all

# Ports pour Spring Boot
EXPOSE 8080

# Git safe config pour CI/CD
RUN git config --global --add safe.directory /workspace
RUN git config --global credential.helper 'store'

# Cache Gradle
VOLUME /root/.gradle

# Mode interactif pour CI/CD ou debug
CMD ["bash"]
