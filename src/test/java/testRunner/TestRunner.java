package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features={".//Features/"},
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", "html:test-output"},
		tags = {"@dino"}
		//tags = {"@sanity, @regression"}  //OR
		//tags = {"@sanity", "@regression"}  //AND
)
public class TestRunner {

}
