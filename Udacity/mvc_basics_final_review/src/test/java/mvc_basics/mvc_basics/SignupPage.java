package mvc_basics.mvc_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(id = "inputLastName")
    private WebElement firstName;

    @FindBy(id = "inputLastName")
    private WebElement lastName;

    @FindBy(id = "inputUsername")
    private WebElement userName;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "submit-button")
    private WebElement submit;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String string){
        //firstName.clear();
        firstName.sendKeys(string);
    }

    public void enterLastName(String string){
        //firstName.clear();
        lastName.sendKeys(string);
    }

    public void enterUserName(String string){
        //firstName.clear();
        userName.sendKeys(string);
    }

    public void enterPassword(String string){
        //firstName.clear();
        password.sendKeys(string);
        submit.click();
    }


}
