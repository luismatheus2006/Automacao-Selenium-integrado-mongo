package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.framework.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;
import java.nio.file.Path;
public class Hooks {



    @After
    public void tearDown(Scenario scenario) {

        try {

            WebDriver driver = DriverFactory.getDriver();

            if (driver != null) {

                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                String status = scenario.isFailed() ? "erro" : "sucesso";

                scenario.attach(screenshot, "image/png", status);

                Path path = Path.of(
                        "target/screenshots/" +
                                scenario.getName().replaceAll(" ", "_") +
                                "_" + status + ".png"
                );

                Files.createDirectories(path.getParent());
                Files.write(path, screenshot);
            }

        } catch (Exception ignored) {
        } finally {
            DriverFactory.quit();
        }
    }
}