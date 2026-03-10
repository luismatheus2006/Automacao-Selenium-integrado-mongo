package org.framework.utils;


import org.openqa.selenium.*;

public class ElementUtils {

    public static void scrollToElement(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

    }

}