import org.junit.platform.suite.api.*;
import io.cucumber.junit.platform.engine.Cucumber;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "stepDefinitions")
public class TestRunner {
}
