package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchEmployeeStepDefinitions extends CommonMethods{
    List<String> listOfJobTitlesFromDd;
    @When("click on employee list")
    public void click_on_employee_list() {
        click(addEmployeePage.empListBtn);
    }

    @When("enter {string}")
    public void enter(String employeeID) {
        addEmployeePage.enterEmpID(employeeID);
    }

    @When("click on search button")
    public void click_on_search_button() {
        addEmployeePage.clickOnSearchBtn();
    }

    @Then("verify {string} exists in the list")
    public void verify_exists_in_the_list(String employeeID) {
        String expectedEmployeeID = employeeID;

        for (int i = 0; i < addEmployeePage.rowData.size(); i++) {
            String rowText = addEmployeePage.rowData.get(i).getText();
            Assert.assertTrue(rowText.contains(expectedEmployeeID));
        }
    }

    @When("enter {string} and {string}")
    public void enter_and(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        sendText(addEmployeePage.fullEmpNameSearchField, fullName);
    }

    @Then("verify {string} and {string} exist in the list")
    public void verify_and_exist_in_the_list(String firstName, String lastName) {
        String expectedFirstName = firstName;

        for (int i = 0; i < addEmployeePage.rowData.size(); i++) {
            String rowText = addEmployeePage.rowData.get(i).getText();
            Assert.assertTrue(rowText.contains(expectedFirstName));
        }

    }

    @When("search for all job titles")
    public void search_for_all_job_titles() {
        List<WebElement> listOfWebElem = getAllOptionsFromDD(pimConfigurationPage.empJobTitleDropDown);
        System.out.println("Dd list size is: " + listOfWebElem.size());
        listOfJobTitlesFromDd = new ArrayList<>();
        for (int i = 1; i < listOfWebElem.size(); i++) {
            String option = listOfWebElem.get(i).getText();
            listOfJobTitlesFromDd.add(option);
        }
    }

    @Then("verify job title data from db and ui is matched")
    public void verify_job_title_data_from_db_and_ui_is_matched() {
        Assert.assertEquals("Verifying Job Titles data", listOfJobTitlesFromDd, GlobalVariables.dbListOfStrings);
    }
}
