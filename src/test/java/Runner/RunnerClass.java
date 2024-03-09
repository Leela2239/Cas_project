package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\2303634\\eclipse-workspace\\CASproject\\CASproject\\FeaturedFiles\\featnews.feature" ,
		glue="Stepdefinition",plugin = {"pretty", "html:reports/myreport.html","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,
         dryRun=false,
         monochrome=true,
         publish=true)

public class RunnerClass {

}
