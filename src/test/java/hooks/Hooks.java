package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.framework.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot)
                    DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png","erro");

        }

        DriverFactory.quit();
    }

}