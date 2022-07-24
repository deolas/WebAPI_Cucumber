package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
		glue={"stepDefinitions"},
		tags= "@regression11",
		plugin= {"pretty","html:test-output"})
public class TestRunner { }
