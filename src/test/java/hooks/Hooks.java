package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.framework.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        try {
            WebDriver driver = DriverFactory.getDriver();

            if (driver != null && scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "erro");
            }
        } catch (Exception ignored) {
        } finally {
            DriverFactory.quit();
        }
    }
}