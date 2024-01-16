#!/bin/bash

CHART_NAME="my-app-chart"
RELEASE_NAME="my-app-chart"
CHART_VERSION="0.1.0"
NAMESPACE="default"
CHART_PATH="$HOME/minikube/restapi/k8s/my-app-chart"
helm package $CHART_PATH

if helm status $RELEASE_NAME --namespace $NAMESPACE >/dev/null 2>&1; then
  helm upgrade $RELEASE_NAME $CHART_NAME-$CHART_VERSION.tgz --namespace $NAMESPACE
else
  helm install $RELEASE_NAME $CHART_NAME-$CHART_VERSION.tgz --namespace $NAMESPACE
fi

kubectl port-forward svc/my-app-chart-service 8084:8080