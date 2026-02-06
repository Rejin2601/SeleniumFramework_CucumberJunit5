package helper;

import utils.DriverFactory;

public class TestContext {
    private DriverFactory driverFactory;
    private ScenarioContext scenarioContext;

    public TestContext() {
        driverFactory = new DriverFactory();
        scenarioContext = new ScenarioContext();
    }

    public DriverFactory getDriverFactory() {
        return driverFactory;
    }
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}