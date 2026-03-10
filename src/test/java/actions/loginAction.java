package actions;

import org.framework.driver.DriverFactory;
import org.framework.utils.FakerUtils;
import org.framework.utils.MongoUtils;
import org.framework.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class loginAction {

        WebDriver driver = DriverFactory.getDriver();



        public static String getEmail(){

            String email = MongoUtils.getField("email");

            if(email == null){

                email = FakerUtils.generateEmail();

                MongoUtils.setField("email", email);

            }

            return email;
        }

        public static String getPassword(){

            String pass = MongoUtils.getField("password");

            if(pass == null){

                pass = FakerUtils.generatePassword();

                MongoUtils.setField("password", pass);

            }

            return pass;
        }

        public void openSite(){
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
