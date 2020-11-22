package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/Features/Calculate.feature",
        glue = "stepDefenitions",
        dryRun = false,
        plugin = {"pretty", "html:test-outputs.html"}
)


public class TestRunner {
}
