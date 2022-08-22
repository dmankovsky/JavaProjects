package com.udacity.jwdnd.course1.cloudstorage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestNote {
    public WebDriver webDriver;
    private WebDriverWait webDriverWait;
    //private HelperMethods hm;

    private final By navNotesTab = By.id("nav-notes-tab");
    private final By logoutButton = By.id("logoutButton");
    private final By addANewNoteButton = By.id("addANewNoteButton");
    private final By editNoteButton = By.id("editNoteButton");
    private final By deleteNoteButton = By.id("deleteNoteButton");
    //private final By mainNoteTitle = By.cssSelector("#notesTable tbody tr th:nth-of-type(1)");
    private final By mainNoteTitle = By.xpath("//*[@id=\"notesTable\"]/tbody/tr/th");
    //private final By mainNoteDescription = By.cssSelector("#notesTable tbody tr td:nth-of-type(2)");
    private final By mainNoteDescription = By.xpath("//*[@id=\"notesTable\"]/tbody/tr/td[2]");

    private final By noteModalLabel = By.id("noteModalLabel");
    private final By noteTitle = By.id("note-title");
    private final By noteDescription = By.id("note-description");
    private final By saveChangesButton = By.id("saveChangesButton");
    private final By saveSuccessMsg = By.id("saveSuccessMsg");

    @Autowired
    public TestNote(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // add note
    public void addNote(String title, String description){
        goToNotesTab();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(addANewNoteButton));
        webDriver.findElement(addANewNoteButton).click();
        threadSleepSeconds(2);
        inputNote(title, description);
        threadSleepSeconds(2);
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveSuccessMsg")));
        //webDriver.findElement(By.id("saveSuccessMsg")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("saveSuccessMsg")));
        webDriver.findElement(By.id("saveSuccessMsg")).click();
        threadSleepSeconds(2);
    }
    // input note
    public void inputNote(String title, String description){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noteModalLabel")));

        webDriver.findElement(noteTitle).clear();
        webDriver.findElement(noteTitle).sendKeys(title);
        webDriver.findElement(noteDescription).clear();
        webDriver.findElement(noteDescription).sendKeys(description);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveChangesButton")));
        WebElement saveChangesButton = webDriver.findElement(By.id("saveChangesButton"));
        threadSleepSeconds(2);
        saveChangesButton.click();
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noteModalLabel")));
    }
    // edit note
    public void editNote(String title, String description){
        //addNote(title, description);
        //String newTitle = "newTitle";
        //String newDescription = "newDescription";
        webDriver.findElement(navNotesTab).click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(editNoteButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editNoteButton));
        webDriver.findElement(editNoteButton).click();
        inputNote(title, description);
        webDriver.findElement(By.id("saveSuccessMsg")).click();
        //clickToReturnToHomePage();
        //goToNotesTab();
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(addANewNoteButton));
        //clickToReturnToHomePage();
        //goToNotesTab();
        //hm.waitUntilElementClickable(addANewNoteButton);
    }
    // click to return to home page
//    public void clickToReturnToHomePage(){
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
//        //hm.waitUntilElementVisible(saveSuccessMsg);
//        webDriver.findElement(By.id("saveSuccessMsg")).click();
//        //hm.clickElement(saveSuccessMsg);
//        //hm.threadSleepSeconds(2);
//        //hm.waitUntilElementInvisible(noteModalLabel);
//        //hm.waitUntilElementClickable(logoutButton);
//        //hm.waitUntilElementClickable(navNotesTab);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
//    }

    // go to notes tab
    public void goToNotesTab(){
        //hm.clickElement(navNotesTab);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        webDriver.findElement(navNotesTab).click();
        //hm.waitUntilElementClickable(addANewNoteButton);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addANewNoteButton));
    }
    // delete note
    public void deleteNote(){
        //hm.clickElement(deleteNoteButton);
        webDriver.findElement(By.id("deleteNoteButton")).click();
        //hm.waitUntilElementInvisible(addANewNoteButton);
        threadSleepSeconds(2);
        //clickToReturnToHomePage();
        //goToNotesTab();
        //hm.waitUntilElementClickable(addANewNoteButton);
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("addANewNoteButton")));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveSuccessMsg));
        webDriver.findElement(saveSuccessMsg).click();
    }
    // get title
    public String getTitle(){
        //return hm.getElementText(mainNoteTitle);
        return getElementText(mainNoteTitle);
    }
    // get description
    public String getDescription(){
        return getElementText(mainNoteDescription);
    }
    // get no of notes
    public int getNoOfNotes(){
        return webDriver.findElements(mainNoteTitle).size();
    }

    public String getElementText(By element){
        return webDriver.findElement(element).getText();
    }

    // logout
    public void logout(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        webDriver.findElement(By.id("logoutButton")).click();
    }

    public void threadSleepSeconds(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        } catch(InterruptedException ie){
        }
    }
}
