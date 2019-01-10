FROM docker.bintray.io/jfrog/artifactory-oss:5.5.1

COPY artifactory.config.import.yml /var/opt/jfrog/artifactory/etc/artifactory.config.import.yml

ENTRYPOINT ["/bin/sh", "-c", "/entrypoint-artifactory.sh"]