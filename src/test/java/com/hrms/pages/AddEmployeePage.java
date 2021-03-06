package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEmployeePage extends CommonMethods{

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "photofile")
    public WebElement photograph;

    @FindBy(id = "chkLogin")
    public WebElement addLoginDetailsCheckBox;

    @FindBy(id = "user_name")
    public WebElement userNameField;

    @FindBy(id = "user_password")
    public WebElement userPassField;

    @FindBy(id = "re_password")
    public WebElement confirmPassField;

    @FindBy(id = "btnSave")
    public WebElement saveBtn;

    @FindBy(id = "employeeId")
    public WebElement empID;

    @FindBy(id = "empsearch_id")
    public WebElement empSearchId;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement empListBtn;

    @FindBy (id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@id = 'profile-pic']//following-sibling::h1")
    public WebElement userProfileName;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement fullEmpNameSearchField;

    @FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr")
    public List<WebElement> rowData;

    public AddEmployeePage(){
        PageFactory.initElements(CommonMethods.driver,this);
    }
    public void enterFirstAndLastName(String firstName, String lastName){
        sendText(firstNameField, firstName);
        sendText(lastNameField, lastName);
    }
    public void enterFirstMiddleAndLastName(String firstName, String middleName, String lastName){
        sendText(firstNameField, firstName);
        sendText(middleNameField, middleName);
        sendText(lastNameField, lastName);
    }
    public void enterEmployeeId(String employeeId){
        sendText(empID, employeeId);
    }
    public void clickOnSaveBtn(){
        jsClick(saveBtn);
    }
    public String getUserProfileName(){
        return userProfileName.getText();
    }
    public void enterEmpID(String employeeID){
        sendText(empSearchId, employeeID);
    }
    public void clickOnSearchBtn(){
        jsClick(searchBtn);
    }
}
