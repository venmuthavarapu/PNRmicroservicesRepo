Feature: get employee Details
Background:
    Given register EndPoint like "https://jsonplaceholder.typicode.com"
    
Scenario: Get All posts
    And define HTTP request
    When submit requst via get method to Restful Service
    Then Status code is "200" and content Type is "application/json"

Scenario: Get Specific Posts
    And define HTTP request
    When submit requst for id "1" via get method to Restful Service
    Then Status code is "200" and id is "1" in json response

