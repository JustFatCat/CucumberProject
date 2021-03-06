package com.hrms.stepdefinitions;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.DbUtils;

import java.util.List;

public class FunctionTest {
    public static void main(String[] args) {
        /*ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String query = "Select emp_firstname, emp_middle_name, emp_lastname from hs_hr_employees where employee_id = 13887";
        List<Map<String,String>> list = DbUtils.getDbDataIntoListOfMaps(query);
        System.out.println(list);
        System.out.println(list.size());*/

        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String query = "Select job_title from ohrm_job_title;";
        List<String> list = DbUtils.getDbDataIntoListOfStrings(query);
        System.out.println(list);
        System.out.println(list.size());

    }

}
