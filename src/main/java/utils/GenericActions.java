package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericActions {
    private WebDriver driver;

    public GenericActions(WebDriver driver){
        this.driver = driver;
    }

    public void getUrl(String url){
        driver.get(url);
    }

    public void click(By element){
        driver.findElement(element).click();
    }
    public void enterValue(By element, String value){
        driver.findElement(element).sendKeys(value);
    }
    public String getText(By element){
        return driver.findElement(element).getText();
    }

    public void waitUntilElementClickable(By element, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
