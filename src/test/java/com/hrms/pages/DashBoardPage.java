package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DashBoardPage extends CommonMethods {
    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(id= "menu_pim_viewPimModule")
    public WebElement pimBtn;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeBtn;
    
    @FindBy(xpath = "//div[@class = 'menu']/ul/li")
    public List<WebElement> dashTabs;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnPIM(){
        jsClick(pimBtn);
    }
    public void clickOnAddEmployeeBtn(){
        jsClick(addEmployeeBtn);
    }
    public List<String> getDashTabs(){
        List<String> dashTabsText = new ArrayList<>();
        for (WebElement dashTab:dashTabs) {
            dashTabsText.add(dashTab.getText());
        }
        return dashTabsText;
    }
}
