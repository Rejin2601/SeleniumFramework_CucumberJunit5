package runnerFile;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Path to your feature files
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "stepDefinitions,hooks" // Package containing your StepDefs
)
public class TestRunner {
}