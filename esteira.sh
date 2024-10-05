#!/bin/bash

echo "stage build"
mvn clean install

if [[ $? != 0 ]]; then
    echo "build falhou"
    exit 1
fi

echo "stage docker build"
docker build -t alexsouzasilva/ms-find-car:latest .

if [[ $? != 0 ]]; then
    echo "docker falhou"
    exit 1
fi