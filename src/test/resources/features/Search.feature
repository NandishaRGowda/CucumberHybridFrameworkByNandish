Feature:  Search Functionality

Scenario: user searchs valid product
Given user opens the Application
When user enter valid product "HP" into searcxh field 
And user clicks on Search button
Then Valid product displayed in search results

Scenario: user searchs Invalid product
Given user opens the Application
When user enter INvalid product "Honda" into searcxh field 
And user clicks on Search button
Then user should get a warning message about no product matching

Scenario: user searchs without any product
Given user opens the Application
When user dont enter any product into searcxh field 
And user clicks on Search button
Then user should get a warning message about no product matching