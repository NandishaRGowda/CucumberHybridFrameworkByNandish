Feature: Login Functionality

Scenario Outline: Login With Valid credentials
Given user navigates to Login Page
When  user enter Valid email Address <UserName> into email field
And  user enter valid password <Password> into password field
And  user click on Login button
Then user should Successfully Logged in 
Examples:
|UserName          |Password|
|nandi2@gmail.com  |123456  |
|nandi3@gmail.com  |123456  | 
|nandi6@gmail.com  |123456  |

Scenario: Login with Invalid credentilas 
Given user navigates to Login Page
When  user enter Valid email Address "nandi1@gmail.com" into email field
And user enters invalid password "1234567" into the password field 
And  user click on Login button 
Then user should not Logged in and get proper warning message
 
Scenario: Login with Valid emai and Invalid password
Given user navigates to Login Page
When  user enter Valid email Address "nandi1@gmail.com" into email field
And user enters invalid password "1234567" into the password field 
And  user click on Login button 
Then user should not Logged in and get proper warning message 

Scenario: Login with InValid emai and valid password
Given user navigates to Login Page 
When  user enter InValid email Address into email field
And  user enter valid password "123456" into password field 
And  user click on Login button 
Then user should not Logged in and get proper warning message 

Scenario: Login without Credentials 
Given user navigates to Login Page
When user dont enter email address into email field
And user dont enter password into password field  
And  user click on Login button 
Then user should not Logged in and get proper warning message
