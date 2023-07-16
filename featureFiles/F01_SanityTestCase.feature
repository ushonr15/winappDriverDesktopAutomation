Feature: Open Notepad ++ 
@sanity 
Scenario: Open Notepad , put some text and save it to local 
Given I start Notepadd++ application
And I click on Menu "File>New"
Then I validate "" tab visible
Then I enter "Some text" in text box
