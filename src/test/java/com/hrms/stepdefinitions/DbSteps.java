package com.hrms.stepdefinitions;

import com.hrms.utils.DbUtils;
import com.hrms.utils.GlobalVariables;
import io.cucumber.java.en.Then;

public class DbSteps {
    @Then("collect employee data from hrms database")
    public void collect_employee_data_from_hrms_database() {
        String query = "Select emp_firstname, emp_middle_name, emp_lastname "
                + "from hs_hr_employees where employee_id="
                + GlobalVariables.emp_Id;
        GlobalVariables.dbListOfMaps = DbUtils.getDbDataIntoListOfMaps(query);
    }

    @Then("get all job titles from db")
    public void get_all_job_titles_from_db() {
        String query = "Select job_title from ohrm_job_title";
        GlobalVariables.dbListOfStrings = DbUtils.getDbDataIntoListOfStrings(query);
    }
}
