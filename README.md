# Pending Approval List
**Pending Approval List** component provides easy access to Pending Approvals assigned to User or Queue. This components includes **Approve,** **Reject**, and **Reassign** actions.

<br />


## Configurations
There are two Custom Metadata Types to support the configuration of Pending Approval List which are **Approval List** and **Approval List Field**. 

<br />

### Approval List

| Field Name | Description |
|------------|-------------|
| Label      | Provide the name for Approval List. This value will be required to pass while configuring/dragging the component on page. |
|Approval List Name | Unique name for Approval List Record. |
| Object Name | Object for which you want to show approvals. |
| Display Text | This value will be visible as the name of the Approval List on the component|
| Most Recent Approver Sequence | Enter the squence number for **Most Recent  Approver** column. Leave this field empty if you don't want to show this column. |
| Date Submitted Sequence | Enter the squence number for **Date Submitted** column. Leave this field empty if you don't want to show this column. |
| Submitted By Sequence |  Enter the squence number for **Submitted By** column. Leave this field empty if you don't want to show this column. |
| Type Sequence | This field shows Object name with which approval request is associtaed. Enter the squence number for **Type** column. Leave this field empty if you don't want to show this column. |
| Step Name Sequence | Enter the squence number for **Step Name** column. Leave this field empty if you don't want to show this column. |
| Actual Approver Sequence | Enter the squence number for **Actual Approver** column. Leave this field empty if you don't want to show this column. |
| Assigned To Sequence | Enter the squence number for **Assigned To** column. Leave this field empty if you don't want to show this column. |


<br />

### Approval List Field

This configuration help in showing additional columns on **Pending Approval List** from the related record information. 

Example:- There is an approval on Opportunity and you want to show Opportunity Status in the Pending Approval List then you can create one record of Approval List Field.

| Field Name | Description | 
-------------|--------------|
| Label | Provide a label for field configuration.|
| Approval List | Select the **Approval List** record created based on the above information. |
| Output Type | This picklist has following values:- **Text, Date, Dattime, Checkbox,** and **Url**.  Please select output type for data formating.|
| Column Label | Column Label on the Pending Approval List table. |
| Field Api Name | Api name of the field of which you want to show data. Relationship fields are also supported. Field api names must be mentioned relative of the Target object. Example (1):- There is an Approval on Opportunity and you want to show the Opportunity Status field value on the Pending Approval List then you have to mention the field api name as **Status**. Example(2):- There is an Approval on Opportunity and you want to show the Account name field value on the Pending Approval List then you have to mention the field api name as **Account.Name**. |
| Field Api Name (Link Id) | This field is required only when you select the Output type as **Url**. Relationship fields are also supported. Consider the example mentioned for Field Api Name.  |
| Sequence | Sequence of the column. Please note that sequence values mentioned on the Approval List are considered togther with Approval List Field record sequence.|


<br />

### Design Attributes / Page level configurations

`Configuration Name`: This value is same as Approval List's record Label

`Page Size`: Default page size on the Approval List.

`Approve Action` : Check this to make **Approve** action available on column level as well as for bulk action.


`Reject Action` : Check this to make **Reject** action available on column level as well as for bulk action.


`Reassign Action` : Check this to make **Reassign** action available on column level as well as for bulk action. Reassignment of approval list can be done to **User** as well as **Queue**.




