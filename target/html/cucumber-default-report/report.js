$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ConfigurePIM.feature");
formatter.feature({
  "name": "Configure PIM - Optional Fields",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Unchecking unnecessary checkBoxes",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@pim"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "enter valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.enter_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify dashboard is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.verify_dashboard_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on PIM button",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.AddEmployeeStepDefinition.click_on_PIM_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on configuration dropdown",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.PIMConfigurationStepDefinition.click_on_configuration_dropdown()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on optional fields",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.PIMConfigurationStepDefinition.click_on_optional_fields()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on edit button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.PIMConfigurationStepDefinition.click_on_edit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "uncheck unnecessary checkBoxes",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.PIMConfigurationStepDefinition.uncheck_unnecessary_checkBoxes(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.AddEmployeeStepDefinition.click_on_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Unchecking unnecessary checkBoxes");
formatter.after({
  "status": "passed"
});
});