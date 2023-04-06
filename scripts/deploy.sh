#!/bin/bash
# //?project=consious-coder
# Set variables
PROJECT_ID="consious-coder"
IMAGE_NAME="my-spring-boot-app"
TAG_NAME="2.0"
SERVICE_NAME="my-spring-boot-app-service"
REGION="us-west2"
PORT="8080"
REPOSITORY="my-spring-boot-app"

docker build -t ${IMAGE_NAME}:${TAG_NAME} ..
# Tag the image with the registry name
docker tag ${IMAGE_NAME}:${TAG_NAME} ${REGION}-docker.pkg.dev/${PROJECT_ID}/${REPOSITORY}/${IMAGE_NAME}:${TAG_NAME}

# Authenticate Docker to use your Google Cloud project
gcloud auth configure-docker

# Push the image to the registry
docker push ${REGION}-docker.pkg.dev/${PROJECT_ID}/${REPOSITORY}/${IMAGE_NAME}:${TAG_NAME}

# Deploy the image to Cloud Run
gcloud run deploy ${SERVICE_NAME} \
    --image ${REGION}-docker.pkg.dev/${PROJECT_ID}/${REPOSITORY}/${IMAGE_NAME}:${TAG_NAME} \
    --platform managed \
    --region ${REGION} \
    --port ${PORT} \
    --allow-unauthenticated
