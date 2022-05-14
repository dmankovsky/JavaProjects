package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods {

    public WebDriver webdriver;

    public void waitUntilElementVisible(By element){
        WebDriverWait webDriverWait = new WebDriverWait(webdriver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitUntilElementInvisible(By element){
        WebDriverWait webDriverWait = new WebDriverWait(webdriver, 10);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitUntilElementClickable(By element){
        WebDriverWait webDriverWait = new WebDriverWait(webdriver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void inputElementText(By element, String text){
        waitUntilElementVisible(element);
        waitUntilElementClickable(element);
        webdriver.findElement(element).clear();
        webdriver.findElement(element).sendKeys(text);
    }

    public void clickElement(By element){
        waitUntilElementClickable(element);
        webdriver.findElement(element).click();
    }

    public void threadSleepSeconds(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ie){
        }
    }

    public String getElementText(By element){
        return webdriver.findElement(element).getText();
    }

}
