#!/bin/bash

DEPLOYMENT_FILE="k8s/deployment.yaml"
SERVICE_FILE="k8s/service.yaml"
INGRESS_FILE="k8s/ingress.yaml"
CLUSTER_ROLE_FILE="k8s/ClusterRole.yaml"
CLUSTER_ROLE_BINDING_FILE="k8s/ClusterRoleBinding.yaml"

kubectl apply -f "$CLUSTER_ROLE_FILE"
kubectl apply -f "$CLUSTER_ROLE_BINDING_FILE"
kubectl apply -f "$DEPLOYMENT_FILE"
kubectl apply -f "$SERVICE_FILE"
kubectl apply -f "$INGRESS_FILE"

sleep 2

kubectl get deployments
kubectl get services
kubectl get ingresses
