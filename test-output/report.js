$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Customers.feature");
formatter.feature({
  "name": "Customers",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Common steps for each scenario",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launches browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.user_launches_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User opens Url \"https://admin-demo.nopcommerce.com/login\"",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_opens_Url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters email as \"admin@yourstore.com\" and password \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_enters_email_as_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Login button",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_clicks_on_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view Dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_can_view_Dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search Customer by Name",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@dino"
    }
  ]
});
formatter.step({
  "name": "User clicks on customers menu",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_clicks_on_customers_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on customer menu item",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_clicks_on_customer_menu_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters customer first name",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_enters_customer_first_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters customer last name",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_enters_customer_last_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on search button",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_clicks_on_search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should find name in the search table",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_should_find_name_in_the_search_table()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.close_browser()"
});
formatter.result({
  "status": "passed"
});
});