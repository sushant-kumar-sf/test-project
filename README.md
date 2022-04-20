# File Import Wizard
This component provides easy way to import data from **CSV** file. It is build on LWC framework, so it can be used by wraping in Aura as well as LWC components.

## Example

#### example.cmp
```
<aura:component>
    <c:fileImportWizard aura:id="file-import-wizard" 
                            onimportsuccess="{!c.handleImportSuccess}" 
                            onclose="{!c.handleClose}" />
    
    <lightning:button label="Import" 
                        iconName="utility:upload" 
                        onclick="{!c.openFileImportWizard}" />
</aura:component>

```

#### exampleController.js
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
        let recordIds = event.getParam("recordIds");
        let uniqueIdentifier = event.getParam("identifier");
        let fileImportConfigs = event.getParam("configs");
    },
    
    
    handleClose: function(component, event, helper) {
        // Logic to run on post close/cancel of file import wizard
    }
})
```

## Understanding Parameters passed to _openWizard()_ function

#### configName
It is a **required** parameter. <br />
A **File Import Config** record of record type **Config Header** needs to be created. Name of this record will be used as **configName**. <br />
Child records of record type **Config Field** needs to be created under **Config Header** record for mapping object fields with CSV columns. **Revisited this topic in the end**.


#### objectApiName
It is a **required** parameter. <br />
This is the Api Name of SObject in which records are getting imported.

#### preDefinedFields
It is an **optional** parameter. <br />
Developer can decide some fields as predefined fields like parent Id, Record type, owner etc. These fields data can not be overwriten by File import config records. Developer can also make some integer fields as auto increment field by putting attribute **isAutoIncrement: true** and providing starting value in **startValue** attribute.

#### uniqueIdentifier
It is an **optional** parameter. <br />
This can be any unique value of developer's choice. It is received on import success. Useful when many import buttons available on the page.


## Events

#### onimportsuccess
This event is published/fired on successfull import of records. Developer will get **recordIds** of imported record, **identifier** which was passed in **openWizard()** function and **configs** (File import configs) which are used for importing files.


#### onclose
This event is published on cancel/close of **File import wizard**


## File Import Configs
You can create import configuration records under **File Import Configs** Tab

#### Record Types

| Record Type | Description |
|-------------|-------------|
| Config Header | This record Type is used as parent record and it's **Name** field value is used as **configName** parameter. |
| Config Field | This record type is used as child record and it stores field api name and column number mapping. |





 

