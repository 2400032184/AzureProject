# AZURE SUBSCRIPTION VENDING AND ONBOARDING PROCESS DESIGN

## Abstract
Azure Vending Hub is a governance-first self-service prototype for standardizing Azure subscription onboarding. It provides request intake, approval, vending simulation, governance visibility and a path to real Azure automation.

## Problem
Manual subscription setup can cause inconsistent naming, permissions, policies, tags and cost controls.

## Solution
A web portal collects standardized request information. A backend manages the request lifecycle. Approved requests are passed to a vending stage that prepares subscription metadata and landing-zone configuration. Governance is displayed through Policy, RBAC, tags, budget and management-group controls.

## Architecture
User → Portal → REST API → Approval → Vending Engine → Governance → Handoff.
Real Azure integration: REST API → CI/CD → Bicep/Azure CLI → Azure subscription.

## Functional modules
1. Request Portal
2. Request Validation
3. Approval
4. Vending Engine
5. Governance Center
6. Dashboard
7. Azure Automation Artifacts

## Technologies
Java 21, Spring Boot, HTML/CSS/JavaScript, Azure Policy, Azure RBAC, Management Groups, Bicep, Azure CLI.

## Expected outcome
A repeatable, transparent and governance-oriented onboarding process that can be connected to a real Azure tenant.

## Limitation
The current demo is local and does not claim live Azure provisioning.
