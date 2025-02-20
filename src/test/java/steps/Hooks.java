package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DriverManager;
import utilities.ThreadManager;

import java.io.IOException;

public class Hooks {
    DriverManager drivermanager = new DriverManager();

    @Before
    public void setUp(Scenario scenario) throws IOException, InterruptedException {
        drivermanager.setUp("chrome");
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] screenshotBytes = ((TakesScreenshot) ThreadManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotBytes, "image/png", scenario.getName());
        drivermanager.tearDown();
    }
}
