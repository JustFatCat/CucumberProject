package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelReading;
import com.hrms.utils.GlobalVariables;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddEmployeeStepDefinition extends CommonMethods{
    String currentEmpId;
    @When("click on PIM button")
    public void click_on_PIM_button() {
        dashBoardPage.clickOnPIM();
    }

    @When("click on add employee button")
    public void click_on_add_employee_button() {
        dashBoardPage.clickOnAddEmployeeBtn();
    }

    @Then("enter first name and last name")
    public void enter_first_name_and_last_name() {
        addEmployeePage.enterFirstAndLastName("Thor12", "Potter12");
    }

    @Then("get employee id")
    public void get_employee_id() {
        currentEmpId = addEmployeePage.empID.getText();
    }

    @Then("click on save button")
    public void click_on_save_button() {
        addEmployeePage.clickOnSaveBtn();
    }

    @Then("verify that employee exists in the list")
    public void verify_that_employee_exists_in_the_list() {
        click(addEmployeePage.empListBtn);
        sendText(addEmployeePage.empSearchId, currentEmpId);
        click(addEmployeePage.searchBtn);
        List<WebElement> rowData = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));

        for (int i = 0; i < rowData.size(); i++) {
            String rowText = rowData.get(i).getText();
            Assert.assertTrue(rowText.contains(currentEmpId));
        }
    }
    @Then("verify employee is added successfully")
    public void verify_employee_is_added_successfully() {
        String actualProfileName = addEmployeePage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", "Thor12 Potter12", actualProfileName);
    }

    @Then("enter first name {string}, middle name {string} and last name {string}")
    public void enter_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {
        addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
        GlobalVariables.employeeData = firstName + " " + middleName + " " + lastName;
    }

    @Then("verify that {string} is added successfully")
    public void verify_that_is_added_successfully(String fullName) {
        String actualProfileName = addEmployeePage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

    @When("enter {string}, {string} and {string}")
    public void enter_and(String firstName, String middleName, String lastName) {
        addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
    }

    @Then("verify {string}, {string} and {string} is added successfully")
    public void verify_and_is_added_successfully(String firstName, String middleName, String lastName) {
        String fullName = firstName + " " + middleName + " " + lastName;
        String actualProfileName = addEmployeePage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String,String>> employeeNames = employees.asMaps();
        for(Map<String,String> employeeName:employeeNames){
            String firstName = employeeName.get("FirstName");
            String middleName = employeeName.get("MiddleName");
            String lastName = employeeName.get("LastName");
            String employeeId = employeeName.get("EmployeeId");

            addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
            addEmployeePage.enterEmployeeId(employeeId);
            addEmployeePage.clickOnSaveBtn();
            String actualFullName = addEmployeePage.getUserProfileName();
            String expectedFullName = firstName + " " + middleName + " " + lastName;
            Assert.assertEquals("Verifying profile name", expectedFullName, actualFullName);
            dashBoardPage.clickOnAddEmployeeBtn();
            Thread.sleep(2000);
        }
    }

    @When("add multiple employees from excel {string} sheet and verify they are added")
    public void add_multiple_employees_from_excel_sheet_and_verify_they_are_added(String sheetName) throws InterruptedException {
        List<Map<String,String>> excelData = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        for (Map<String,String> excelEmpName:excelData) {
            String firstName = excelEmpName.get("FirstName");
            String middleName = excelEmpName.get("MiddleName");
            String lastName = excelEmpName.get("LastName");
            String employeeId = excelEmpName.get("EmployeeId");

            addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
            addEmployeePage.enterEmployeeId(employeeId);
            addEmployeePage.clickOnSaveBtn();
            String actualFullName = addEmployeePage.getUserProfileName();
            String expectedFullName = firstName + " " + middleName + " " + lastName;
            Assert.assertEquals("Verifying profile name", expectedFullName, actualFullName);
            dashBoardPage.clickOnAddEmployeeBtn();
            Thread.sleep(2000);
        }
    }

    @When("capture employeeId")
    public void capture_employeeId() {
        GlobalVariables.emp_Id = addEmployeePage.empID.getAttribute("value");
    }

    @Then("verify data from db and ui is matched")
    public void verify_data_from_db_and_ui_is_matched() {
        //one way
        String employeeFromDb = "";
        for (Map<String,String> emp:GlobalVariables.dbListOfMaps) {
            employeeFromDb = emp.get("emp_firstname") + " " + emp.get("emp_middle_name") + " " + emp.get("emp_lastname");
        }
        Assert.assertEquals("Verifying UI employee info matches Db employee info", GlobalVariables.employeeData, employeeFromDb);

        //another way
        String expectedEmployeeData = GlobalVariables.employeeData;
        String actualEmployeeData = "";

        for (Map<String,String> actualEmployeeDataMap:GlobalVariables.dbListOfMaps) {
            Set<String> keys = actualEmployeeDataMap.keySet();
            for (String key:keys) {
                actualEmployeeData += actualEmployeeDataMap.get(key) + " ";
            }
        }
        actualEmployeeData = actualEmployeeData.trim();
        Assert.assertEquals("Verifying Employee Data", actualEmployeeData, expectedEmployeeData);
    }
}
