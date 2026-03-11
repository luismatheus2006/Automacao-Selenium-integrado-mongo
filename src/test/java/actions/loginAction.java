package actions;

import org.framework.driver.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.framework.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class loginAction {

        WebDriver driver = DriverFactory.getDriver();
        private static final Logger log = LoggerFactory.getLogger(loginAction.class);


    public void openSite(){
        log.info("Abrindo site");
        driver.get("https://qualeagiria.com.br/");
        }

        public void clickLogin(){

            WaitUtils.waitElement(driver, LoginPage.loginButton).click();

        }

        public void fillEmail(String email){

            WaitUtils.waitElement(driver, LoginPage.emailInput).sendKeys(email);

        }

        public void fillPassword(String pass){

            WaitUtils.waitElement(driver, LoginPage.passwordInput).sendKeys(pass);

        }

        public void clickEntrar(){

            WaitUtils.waitElement(driver, LoginPage.entrarButton).click();

        }

        public void login(String email, String pass){

            clickLogin();

            fillEmail(email);

            fillPassword(pass);

            clickEntrar();

        }


}
