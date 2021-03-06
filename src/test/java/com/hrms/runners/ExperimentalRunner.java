package com.hrms.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
                 glue = "com/hrms/stepdefinitions",
                 dryRun = false,
                 tags = {"@pim"},
                 monochrome = true,
                 plugin = {"pretty",
                         "html:target/html/cucumber-default-report",
                         "json:target/cucumber.json",
                         "rerun:target/failed.txt"})
public class ExperimentalRunner {

}
