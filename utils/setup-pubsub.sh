#!/bin/bash

gcloud beta emulators pubsub start --host-port=0.0.0.0:8085 &
sleep 30
export PUBSUB_EMULATOR_HOST=localhost:8085
PROJECT_ID=bullla-one-d-apps-cn
TOPIC_ID=business-client-updated
TOPIC_ID_BUSINESS_CLIENT_CREATED=business-client-created
TOPIC_ID_EMPLOYEE_CREATED=employee-created
TOPIC_ID_EMPLOYEE_UPDATED=employee-updated
TOPIC_ID_EMPLOYEE_STATUS_UPDATED=employee-status-updated
SUBSCRIPTION_ID=business-client-updated-sub
curl -X PUT "http://localhost:8085/v1/projects/$PROJECT_ID/topics/$TOPIC_ID"
curl -X PUT "http://localhost:8085/v1/projects/$PROJECT_ID/topics/$TOPIC_ID_BUSINESS_CLIENT_CREATED"
curl -X PUT "http://localhost:8085/v1/projects/$PROJECT_ID/topics/$TOPIC_ID_EMPLOYEE_CREATED"
curl -X PUT "http://localhost:8085/v1/projects/$PROJECT_ID/topics/$TOPIC_ID_EMPLOYEE_UPDATED"
curl -X PUT "http://localhost:8085/v1/projects/$PROJECT_ID/topics/$TOPIC_ID_EMPLOYEE_STATUS_UPDATED"
curl -X PUT "http://localhost:8085/v1/projects/$PROJECT_ID/subscriptions/$SUBSCRIPTION_ID" -H "Content-Type: application/json" -d "{\"topic\": \"projects/$PROJECT_ID/topics/$TOPIC_ID\"}"
tail -f /dev/null
