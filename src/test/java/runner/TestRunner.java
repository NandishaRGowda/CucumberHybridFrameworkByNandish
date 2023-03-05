package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",
			      glue= {"stepdefinations","hooks"},
			      publish=true,
			      plugin={"pretty","html:target/CucumberReports/cucumberReport.html"})


public class TestRunner {

}
