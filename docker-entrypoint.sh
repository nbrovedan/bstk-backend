#!/bin/bash
# DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
# 
# Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
if [[ -z $ADMIN_PASSWORD ]]; then
	ADMIN_PASSWORD="admin"
	echo "##########GENERATED ADMIN PASSWORD: $ADMIN_PASSWORD  ##########"
fi
echo "AS_ADMIN_PASSWORD=" > /tmp/glassfishpwd
echo "AS_ADMIN_NEWPASSWORD=${ADMIN_PASSWORD}" >> /tmp/glassfishpwd
asadmin --user=admin --passwordfile=/tmp/glassfishpwd change-admin-password --domain_name domain1
asadmin start-domain
echo "AS_ADMIN_PASSWORD=${ADMIN_PASSWORD}" > /tmp/glassfishpwd
asadmin --user=admin --passwordfile=/tmp/glassfishpwd enable-secure-admin
echo "########## DEPLOYMENT ###########"
cp ./bstk-backend.war /glassfish4/glassfish/domains/domain1/applications/
asadmin --user=admin --passwordfile=/tmp/glassfishpwd deploy ./glassfish4/glassfish/domains/domain1/applications/bstk-backend.war
rm -f ./bstk-backend.war
asadmin --user=admin stop-domain
rm /tmp/glassfishpwd
exec "$@"