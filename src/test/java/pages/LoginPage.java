package pages;

import org.openqa.selenium.*;

public class LoginPage {

        public static By loginButton =
                By.xpath("//a[contains(text(),'Login')]");

        public static By emailInput =
                By.cssSelector("input[type='email']");

        public static By passwordInput =
                By.cssSelector("input[type='password']");

        public static By entrarButton =
                By.xpath("//button[contains(text(),'Entrar')]");


}