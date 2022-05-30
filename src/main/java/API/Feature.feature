Feature: Adding User
  Description: The purpose of this feature is to check Add new user.

@SmokeTest
  Scenario Outline: Post
    Given the valid endpoint to create user
    When the request is send to server
    Then the new user created with status code as "<status>"
    
     

    Examples:
      | status   |
      | 201      |  
      
         
@SmokeTest
Scenario Outline: Get

Given the valid endpoint to return user data
When the request is send to server with id as "<id>"
Then validate the response of this user record having first name as "<firstname>"

Examples:
   
   |id | firstname  |
   |10 | Sara       |
   