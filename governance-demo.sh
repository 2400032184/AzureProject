#!/bin/bash
# Run only in an authorized Azure environment.
az group create --name rg-sandbox-travel-booking --location eastus   --tags Environment=Sandbox Owner=travel-team CostCenter=CC1001 Project=SubscriptionVending

az policy assignment create --name require-environment-tag   --display-name "Require Environment Tag"   --policy "Require a tag on resources"

az role assignment create   --assignee <APPLICATION_TEAM_OBJECT_ID>   --role "Contributor"   --scope /subscriptions/<SUBSCRIPTION_ID>/resourceGroups/rg-sandbox-travel-booking
