package hooks;


import io.cucumber.java.After;
import org.framework.driver.DriverFactory;

public class Hooks {

    @After
    public void tearDown(){

        DriverFactory.quit();

    }

}