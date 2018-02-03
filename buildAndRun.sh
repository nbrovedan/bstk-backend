#!/bin/sh
mvn clean package && docker build -f Dockerfile -t nbrovedan/bstk-backend .
docker rm -f bstk-backend || true && docker run -d -p 8080:8080 -p 4848:4848 --name bstk-backend nbrovedan/bstk-backend