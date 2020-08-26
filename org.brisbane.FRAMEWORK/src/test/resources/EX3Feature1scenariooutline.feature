Feature: posts creation
Scenario:
Given test restful service
|end point													 |uid|id|title |body    |criteria |sc |
|https://jsonplaceholder.typicode.com|10|101|wishes|abest Rg|unique   |201|
|https://jsonplaceholder.typicode.com|10|101|wishes|balugws |unique   |201|
|https://jsonplaceholder.typicode.com|10|101|wishes|balugws |duplicate|200|