package com.hrms.testbase;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashBoardPage;
import com.hrms.pages.LoginPage;
import com.hrms.pages.PIMConfigurationPage;
import com.hrms.utils.apiCommonMethods;

public class PageInitializer extends BaseClass{

    public static LoginPage loginPage;
    public static DashBoardPage dashBoardPage;
    public static AddEmployeePage addEmployeePage;
    public static PIMConfigurationPage pimConfigurationPage;
    public static apiCommonMethods apiMethods;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        addEmployeePage = new AddEmployeePage();
        pimConfigurationPage = new PIMConfigurationPage();
        apiMethods = new apiCommonMethods();
    }
}

