# 3–5 Minute Hackathon Demo Script

## Opening
"Organizations often need new Azure subscriptions, but manual setup can create delays and inconsistent governance. Our solution is Azure Vending Hub."

## Demo
1. Show Dashboard: requests, pending, approved and vended counts.
2. New Request: enter Travel Booking Portal / travel-team / Sandbox / eastus / CC1001.
3. Submit and return to Dashboard.
4. Approve the request.
5. Click Vend.
6. Open Governance Center and explain Policy, RBAC, tags, budget and management group.
7. Open Workflow and explain request → validate → approve → vend → govern → handoff.

## Innovation points
- Self-service request experience.
- Governance-first vending.
- Standardized metadata.
- Least-privilege RBAC.
- Policy and cost guardrails.
- Clear path from local prototype to Azure automation.

## Closing
"Our prototype separates the user experience from the provisioning engine. With an authorized Azure tenant, the same approved request can trigger Bicep/Azure CLI automation instead of the simulated vending action."
