Feature: posts creation
Scenario Outline: create a new post
Given register EndPoint like "https://jsonplaceholder.typicode.com"
And define HTTP request
When submit requst via post with "<uid>","<id>","<title>", and "<body>" to service
Then Status code is "<sc>" as per "<criteria>" and content Type is "application/json"
Examples:
|uid|id|title|body|criteria|sc|
|10|101|wishes|abest Rg|unique|201|
|10|101|wishes|balugws|unique|201|
|10|101|wishes|balugws|duplicate|200|