
# DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
# 
# Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
# 
# GlassFish on Docker with Oracle Linux and OpenJDK
FROM nbrovedan/bstk-backend

# Maintainer
MAINTAINER Naidion Brovedan<brovedan@gmail.com>

# Set environment variables and default password for user 'admin'
ENV PATH=$PATH:/glassfish5/bin \
    JAVA_HOME=/usr/lib/jvm/java-openjdk

COPY docker-entrypoint.sh /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]

# Ports being exposed
EXPOSE 4848 8080 8181

# Start asadmin console and the domain
CMD ["asadmin", "start-domain", "-v"]