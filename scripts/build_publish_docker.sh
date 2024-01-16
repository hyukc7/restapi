#!/bin/bash

pushd /Users/hyukchung/minikube/restapi

mvn clean package

# exports for minikube for docker
# shellcheck disable=SC2046
eval $(minikube docker-env)

# Define variables
DOCKER_IMAGE_NAME="restapi"
DOCKER_IMAGE_TAG=$(date +"%Y%m%d%H%M%S")
DOCKER_BUILD_CONTEXT="."

# Build Docker image
docker build -t "${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}" "${DOCKER_BUILD_CONTEXT}"
popd