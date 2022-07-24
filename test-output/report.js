$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Login_API.feature");
formatter.feature({
  "name": "User should be able to Login.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify user Login through API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login_api"
    },
    {
      "name": "@api"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "application is up and reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsAPI.initialize_comment_api_spec()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login with username as \"test-f35fe6@test.mailgenius.com\" and password as \"Qwerty\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "verify the response code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "StepsAPI.verify_response_code(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify response time is within configured value",
  "keyword": "And "
});
formatter.match({
  "location": "StepsAPI.verify_response_time()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify the user is created successfully",
  "keyword": "And "
});
formatter.match({
  "location": "StepsAPI.verify_the_user_is_created_successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:Features/Registration_API.feature");
formatter.feature({
  "name": "User should be able to Register.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify user registration through API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register_api"
    },
    {
      "name": "@api"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "application is up and reachable",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsAPI.initialize_comment_api_spec()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Register user with name as \"fego vmos\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepsAPI.create_user(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the response code is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "StepsAPI.verify_response_code(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify response time is within configured value",
  "keyword": "And "
});
formatter.match({
  "location": "StepsAPI.verify_response_time()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the user is created successfully",
  "keyword": "And "
});
formatter.match({
  "location": "StepsAPI.verify_the_user_is_created_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});