param environment string = 'Sandbox'
param location string = 'eastus'
param owner string = 'travel-team'
param costCenter string = 'CC1001'
param application string = 'travel-booking'

resource rg 'Microsoft.Resources/resourceGroups@2025-04-01' = {
  name: 'rg-${toLower(environment)}-${application}'
  location: location
  tags: {
    Environment: environment
    Owner: owner
    CostCenter: costCenter
    Project: 'SubscriptionVending'
  }
}
