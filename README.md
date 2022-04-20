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
| Config Field | This record type is used as child record and it stores field api name and column number mapping with some additional information. |


#### Understanding _Config Header_ Record

| Field Name | Description | Required |
|------------|-------------|----------|
| File Import Config Name | A unique Name used as **configName** in  _openWizard()_ function | true |
| Description | A short note about configuration | false |




 #### Understanding _Config Field Record

| Field Name | Description | Required |
|------------|-------------|----------|
| File Import Config Name | Name of the configuration field |true |
| File Import Config Header | A config header record for which field configuration is getting created | true |
| Field Api Name | Api name of field in which column data is imported | true |
| Data Type | Data type of column | true |
| External Key Api Name | This field required only when data type is **REFERENCE**. The CSV column value is matched against this Api name in order to get the refrenced record Id.<br /> **Use case:** You are importing Contacts and Account's primary email address is available in one of the CSV file column and you have to link accounts with contacts. In this scenarion **Field Api Name** value will be **AccountId** (a field on Contact object) and **External Key Api Name** value will be **PrimaryEmail__c** (a field on Account object)| true |
| Match Case-Sensitive | This field is available only when data type is **REFERENCE**. When checked it match **External Key Api Name** value case sensitively. | false |
| Required | When checked, a value must be provided in CSV cell otherwise it shows an error message to user. | false |
| Data Source | It has two values **CSV File** and **Fixed Value**. When CSV File selected **Column Sequence (Import File)** field appears on the page. When Fixed Value selected **Value** field appears on the page. | true |
| Column Sequence (Import File) | This field is available and required when Data Source is **CSV File**. It stores **column number** of CSV File which data is imported in **Field Api Name** field. It starts from 1 | true |
| Column Name (Import File) | This field is available and required when Data Source is **CSV File**. It stores the column name | true |
| Value | This field is available and required when Data Source is **Fixed Value**. It is used to provide default value for some fields. | true |
| Skip Pre Population | When checked, field config record is skiped while importing data. <br /> **Use case:** You have configured/mapped one CSV file field but you don't want to use it for specific import. | false |
| Format | This field is available and required only when Data Type id **DATE** OR **DATETIME**. It should be the same as the Date format in the CSV file. Example: If the Date in the CSV file is 01/31/2000 then Format will be mm/dd/yyyy. Alphabets are not supported in the Date value. Example:- 01/Jan/2021 is an unacceptable date value from CSV. | true |




