#!/bin/sh
mvn clean -U package && docker build -f Dockerfile -t nbrovedan/bstk-backend .
docker rm -f bstk-backend || true && docker run -p 8080:8080 -p 4848:4848 -v $PWD:/target -w /target --name bstk-backend nbrovedan/bstk-backend