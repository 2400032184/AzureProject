# Viva / Judge Questions

1. What is subscription vending?
A standardized process for requesting, creating/configuring, governing and handing off Azure subscriptions.

2. Why is it useful?
It reduces manual work and makes governance repeatable.

3. Why Management Groups?
They organize subscriptions and support governance at scale.

4. What does Azure Policy do?
It audits or enforces resource configuration rules.

5. What is RBAC?
Role-based authorization controlling actions at a defined scope.

6. Why tags?
For ownership, environment, cost allocation and governance.

7. What is your innovation?
A self-service request-to-handoff workflow with governance checks and a clear automation boundary.

8. Did you create a real Azure subscription?
No. The hackathon prototype runs locally because the team did not have an Azure subscription. The included Bicep/CLI artifacts show how the prototype can be connected to an authorized Azure environment.

9. What happens if a request is invalid?
It should be rejected before provisioning; examples include missing owner/cost center or an unapproved region.

10. How can it be scaled?
Use a database, identity integration, CI/CD, approval workflow and Azure Resource Manager/Bicep automation.
