Feature: Register Functionality 

Scenario: user Registers with only mandatory fields
Given user navigates to Register page
When user enters the deatils to below field
|First Name        |Nandisha        |
|lastname          |SR              |
|Email             |nandi101@gmail.com|
|Telephone         |1234567890      |
|Password          |123456          |
|Confirm Password  |123456          |
 And user select privacy policy check box
 And user clicks on Login button
 Then user account should created succesfully
 
 
 
 Scenario: user Registers with All mandatory fields
Given user navigates to Register page
When user enters the deatils to below field
|First Name        |Nandisha        |
|lastname          |SR              |
|Email             |nandi202@gmail.com|
|Telephone         |1234567890      |
|Password          |123456          |
|Confirm Password  |123456          |
 And user select YES for newsLatter
 And user select privacy policy check box
 And user clicks on Login button
 Then user account should created succesfully
 
 
 
  Scenario: user Registers with alredy exited duplicate account
Given user navigates to Register page
When user enters the duplicate deatils to below field
|First Name        |Nandisha        |
|lastname          |SR              |
|Email             |nandi1@gmail.com|
|Telephone         |1234567890      |
|Password          |123456          |
|Confirm Password  |123456          |
 And user select YES for newsLatter
 And user select privacy policy check box
 And user clicks on Login button
 Then user account shouldnt be created and get warning message
 
 Scenario: user Registers withot enter any deatils into all the fields
Given user navigates to Register page
 When user dont enter any details into all the fields
 And user clicks on Login button
 Then user Account shouldnt be created and get proper error message on every mandatory feilds 
 
 
 