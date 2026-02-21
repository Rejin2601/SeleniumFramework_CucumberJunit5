package hooks;

import helper.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;


public class Hooks {
    private TestContext testContext;

    public Hooks(TestContext context) {
        this.testContext = context;
    }

    @Before
    public void setUp() throws FileNotFoundException {
        testContext.getDriverFactory().getDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws FileNotFoundException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) testContext.getDriverFactory().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
        }
        testContext.getDriverFactory().quitDriver();
    }

}
