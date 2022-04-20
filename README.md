# File Import Wizard
This component provides easy way to import data from csv file

## Example

example.cmp
```
<aura:component>
    <c:fileImportWizard aura:id="file-import-wizard" onimportsuccess="{!c.handleImportSuccess}" onclose="{!c.handleClose}" ></c:fileImportWizard>
    
    <lightning:button label="Import" iconName="utility:upload" onclick="{!c.openFileImportWizard}" />
</aura:component>

```

exampleController.js
```
({
    openFileImportWizard: function(component, event, helper) {
        let configName = "ContactsImport";
        let objectApiName = "Contact";
        let uniqueIdentifier = "ANY_UNIQUE_VALUE"; // This will help in identifying import success when multiple import button available on the page
        let preDefinedFields = [
            { fieldApiName: "RecordTypeId", value: "RECORD_TYPE_ID"},
            { fieldApiName: "AccountId", value: "ACCOUNT_ID"},
            { fieldApiName: "ANY_AUTO_INCREMENT_FIELD", isAutoIncrement: true, startValue: 1}
        ];
        
        component.find("file-import-wizard").openWizard(configName, objectApiName, preDefinedFields, uniqueIdentifier);
    },
    
    
    handleImportSuccess: function(component, event, helper) {
        // Write logic for processing data on import success
        let uniqueIdentifier = event.getParam("identifier");
        let recordIds = event.getParam("recordIds");
        let fileImportConfigs = event.getParam("configs");
    },
    
    
    handleClose: function(component, event, helper) {
        // Logic to run on post close/cancel of file import wizard
    }
})
```
