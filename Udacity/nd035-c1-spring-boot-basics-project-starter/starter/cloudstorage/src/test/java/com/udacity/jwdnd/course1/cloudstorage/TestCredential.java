package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCredential {
    public WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private final By navCredentialsTab = By.id("nav-credentials-tab");
    private final By navNotesTab = By.id("nav-notes-tab");
    private final By logoutButton = By.id("logoutButton");
    private final By addANewCredentialButton = By.id("addANewCredentialButton");
    private final By editCredentialButton = By.id("editCredentialButton");
    private final By deleteCredentialButton = By.id("deleteCredentialButton");
    private final By credentialUrl = By.id("credentialUrl"); //in cred page table
    private final By credentialUsername = By.id("credentialUsername"); //in cred page table
    private final By credentialPassword = By.id("credentialPassword"); //in cred page table
    private final By credentialModalLabel = By.id("credentialModalLabel");
    private final By inputCredentialUrl = By.id("credential-url"); //in modal
    private final By inputCredentialUsername = By.id("credential-username"); //in modal
    private final By inputCredentialPassword = By.id("credential-password"); //in modal
    private final By saveCredentialButton = By.id("saveCredentialButton");
    private final By saveSuccessMsg = By.id("saveSuccessMsg");

    public TestCredential(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void addCredential(String url, String username, String password){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        WebElement addANewCredentialButton = webDriver.findElement(By.id("addANewCredentialButton"));
        addANewCredentialButton.click();
        inputCredential(url, username, password);
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveCredentialButton")));
        //WebElement saveChangesButton = webDriver.findElement(By.id("saveCredentialButton"));
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveSuccessMsg")));
        //webDriver.findElement(By.id("saveSuccessMsg")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveSuccessMsg")));
        webDriver.findElement(By.id("saveSuccessMsg")).click();
        threadSleepSeconds(2);
    }

    public void inputCredential(String url, String username, String password){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("credentialModalLabel")));
        inputElementText(inputCredentialUrl, url);
        inputElementText(inputCredentialUsername, username);
        inputElementText(inputCredentialPassword, password);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(saveCredentialButton));
        webDriver.findElement(saveCredentialButton).click();
        threadSleepSeconds(2);
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveSuccessMsg")));
    }

    public void inputElementText(By element, String text){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        webDriver.findElement(element).clear();
        webDriver.findElement(element).sendKeys(text);
    }

    // fix it
    public void editCredential(String url, String username, String password){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        WebElement addANewCredentialButton = webDriver.findElement(By.id("addANewCredentialButton"));
        addANewCredentialButton.click();
        inputCredential(url, username, password);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveSuccessMsg")));
        webDriver.findElement(By.id("saveSuccessMsg")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutButton")));

    }

    public void deleteCredential(){
        WebElement deleteCredentialButton = webDriver.findElement(By.id("deleteCredentialButton"));
        deleteCredentialButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveSuccessMsg")));
        webDriver.findElement(By.id("saveSuccessMsg")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutButton")));
    }

    public String getElementText(By element){
        return webDriver.findElement(element).getText();
    }

    public void returnToHome(){
        //webDriver.findElement(element).getText();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveSuccessMsg")));
        webDriver.findElement(By.id("saveSuccessMsg")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveSuccessMsg")));
    }

    public Credential createDummmyCredential(){
        Credential credential = new Credential();
        credential.setUrl(webDriver.findElement(inputCredentialUrl).getAttribute("value"));
        credential.setUsername(webDriver.findElement(inputCredentialUsername).getAttribute("value"));
        credential.setPassword(webDriver.findElement(inputCredentialPassword).getAttribute("value"));
        return credential;
    }

    public int getCountOfCredentials(){
        return webDriver.findElements(credentialUrl).size();
    }

    public void logout(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveSuccessMsg")));
        webDriver.findElement(By.id("saveSuccessMsg")).click();
    }

    public void threadSleepSeconds(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        } catch(InterruptedException ie){
        }
    }
}
