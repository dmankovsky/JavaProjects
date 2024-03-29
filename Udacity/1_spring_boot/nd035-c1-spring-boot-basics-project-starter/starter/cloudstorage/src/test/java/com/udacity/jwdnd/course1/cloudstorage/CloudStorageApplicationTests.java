package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.*;


import java.io.File;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;

	private TestNote testNote;
	private TestCredential testCredential;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
		testNote = new TestNote(driver);
		testCredential = new TestCredential(driver);
		//WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	/**
	 * PLEASE DO NOT DELETE THIS method.
	 * Helper method for Udacity-supplied sanity checks.
	 **/
	private void doMockSignUp(String firstName, String lastName, String userName, String password){
		// Create a dummy account for logging in later.

		// Visit the sign-up page.
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
		driver.get("http://localhost:" + this.port + "/signup");
		webDriverWait.until(ExpectedConditions.titleContains("Sign Up"));
		
		// Fill out credentials
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputFirstName")));
		WebElement inputFirstName = driver.findElement(By.id("inputFirstName"));
		inputFirstName.click();
		inputFirstName.sendKeys(firstName);

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputLastName")));
		WebElement inputLastName = driver.findElement(By.id("inputLastName"));
		inputLastName.click();
		inputLastName.sendKeys(lastName);

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername")));
		WebElement inputUsername = driver.findElement(By.id("inputUsername"));
		inputUsername.click();
		inputUsername.sendKeys(userName);

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputPassword")));
		WebElement inputPassword = driver.findElement(By.id("inputPassword"));
		inputPassword.click();
		inputPassword.sendKeys(password);

		// Attempt to sign up.
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-button")));
		WebElement buttonSignUp = driver.findElement(By.id("submit-button"));
		buttonSignUp.click();

		/* Check that the sign up was successful. 
		// You may have to modify the element "success-msg" and the sign-up 
		// success message below depening on the rest of your code.
		*/
		Assertions.assertTrue(driver.findElement(By.id("successMsgTest")).getText().contains("You've successfully signed up!"));
	}

	
	
	/**
	 * PLEASE DO NOT DELETE THIS method.
	 * Helper method for Udacity-supplied sanity checks.
	 **/
	private void doLogIn(String userName, String password)
	{
		// Log in to our dummy account.
		driver.get("http://localhost:" + this.port + "/login");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername")));
		WebElement loginUserName = driver.findElement(By.id("inputUsername"));
		loginUserName.click();
		loginUserName.sendKeys(userName);

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputPassword")));
		WebElement loginPassword = driver.findElement(By.id("inputPassword"));
		loginPassword.click();
		loginPassword.sendKeys(password);

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		webDriverWait.until(ExpectedConditions.titleContains("Home"));

	}

	@Test
	public void testLoginAndSignUp(){
		doMockSignUp("LoginAndSignup","Test","LS","123");
		doLogIn("LS", "123");
		Assertions.assertTrue(driver.getTitle().contains("Home"));
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutButton")));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("logoutButton")));
		driver.findElement(By.id("logoutButton")).click();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
		Assertions.assertFalse(driver.getTitle().contains("Home"));
	}

	/**
	 * PLEASE DO NOT DELETE THIS TEST. You may modify this test to work with the 
	 * rest of your code. 
	 * This test is provided by Udacity to perform some basic sanity testing of 
	 * your code to ensure that it meets certain rubric criteria. 
	 * 
	 * If this test is failing, please ensure that you are handling redirecting users 
	 * back to the login page after a succesful sign up.
	 * Read more about the requirement in the rubric: 
	 * https://review.udacity.com/#!/rubrics/2724/view 
	 */
	@Test
	public void testRedirection() {
		// Create a test account
		doMockSignUp("Redirection","Test","RT","123");
		
		// Check if we have been redirected to the log in page.
		Assertions.assertEquals("http://localhost:" + this.port + "/login", driver.getCurrentUrl());
	}

	/**
	 * PLEASE DO NOT DELETE THIS TEST. You may modify this test to work with the 
	 * rest of your code. 
	 * This test is provided by Udacity to perform some basic sanity testing of 
	 * your code to ensure that it meets certain rubric criteria. 
	 * 
	 * If this test is failing, please ensure that you are handling bad URLs 
	 * gracefully, for example with a custom error page.
	 * 
	 * Read more about custom error pages at: 
	 * https://attacomsian.com/blog/spring-boot-custom-error-page#displaying-custom-error-page
	 */
	@Test
	public void testBadUrl() {
		// Create a test account
		doMockSignUp("URL","Test","UT","123");
		doLogIn("UT", "123");
		
		// Try to access a random made-up URL.
		driver.get("http://localhost:" + this.port + "/some-random-page");
		Assertions.assertFalse(driver.getPageSource().contains("Whitelabel Error Page"));
	}


	/**
	 * PLEASE DO NOT DELETE THIS TEST. You may modify this test to work with the 
	 * rest of your code. 
	 * This test is provided by Udacity to perform some basic sanity testing of 
	 * your code to ensure that it meets certain rubric criteria. 
	 * 
	 * If this test is failing, please ensure that you are handling uploading large files (>1MB),
	 * gracefully in your code. 
	 * 
	 * Read more about file size limits here: 
	 * https://spring.io/guides/gs/uploading-files/ under the "Tuning File Upload Limits" section.
	 */
	@Test
	public void testLargeUpload() {
		// Create a test account
		doMockSignUp("Large File","Test","LFT","123");
		doLogIn("LFT", "123");

		// Try to upload an arbitrary large file
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
		String fileName = "upload5m.zip";

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileUpload")));
		WebElement fileSelectButton = driver.findElement(By.id("fileUpload"));
		fileSelectButton.sendKeys(new File(fileName).getAbsolutePath());

		WebElement uploadButton = driver.findElement(By.id("uploadButton"));
		uploadButton.click();
		try {
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveSuccessMsg")));
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Large File upload failed");
		}
		Assertions.assertFalse(driver.getPageSource().contains("HTTP Status 403 – Forbidden"));

	}

	// test note functionality
	@Test
	public void testAddNote(){
		doMockSignUp("AddNote","Test","AN","123");
		doLogIn("AN", "123");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 102);

		driver.findElement(By.id("nav-notes-tab")).click();
		//WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("addANewNoteButton")));
		testNote.addNote("Test title", "Test description");
		//testNote.clickToReturnToHomePage();
//		try {
//			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveSuccessMsg")));
//		} catch (org.openqa.selenium.TimeoutException e) {
//			System.out.println("Note not added. Error.");
//		}
		//assertFalse(driver.getPageSource().contains("Error"));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-notes-tab")));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("nav-notes-tab")));
		driver.findElement(By.id("nav-notes-tab")).click();
		testNote.threadSleepSeconds(2);
		assertEquals("Test title",testNote.getTitle());
		assertEquals("Test description",testNote.getDescription());
	}

	@Test
	public void testEditNote(){
		doMockSignUp("EditNote","Test","EN","123");
		doLogIn("EN", "123");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 22);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-notes-tab")));
		driver.findElement(By.id("nav-notes-tab")).click();
		//webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("addANewNoteButton")));
		testNote.addNote("Test title", "Test description");
		//driver.findElement(By.id("nav-notes-tab")).click();
		//webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("editNoteButton")));
		//driver.findElement(By.id("editNoteButton")).click();
		testNote.editNote("Test edit title", "Test edit description");
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-notes-tab")));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("nav-notes-tab")));
		driver.findElement(By.id("nav-notes-tab")).click();
		testNote.threadSleepSeconds(2);
		assertEquals("Test edit title",testNote.getTitle());
		assertEquals("Test edit description",testNote.getDescription());
	}

	@Test
	public void testDeleteNote(){
		doMockSignUp("DeleteNote","Test","DN","123");
		doLogIn("DN", "123");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);

		driver.findElement(By.id("nav-notes-tab")).click();
		//webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("addANewNoteButton")));
		testNote.addNote("Test delete title", "Test delete description");
		//testNote.clickToReturnToHomePage();
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-notes-tab")));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("nav-notes-tab")));
		driver.findElement(By.id("nav-notes-tab")).click();
		testNote.threadSleepSeconds(2);
		testNote.deleteNote();
		assertEquals(0, testNote.getNoOfNotes());
	}

	// credential functionality
	@Test
	public void addCredential(){
		doMockSignUp("AddCredential","Test","AC","123");
		doLogIn("AC", "123");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
		driver.findElement(By.id("nav-credentials-tab")).click();
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("addANewCredentialButton")));
		testCredential.addCredential("testurl", "testusername", "testpassword");
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-credentials-tab")));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("nav-credentials-tab")));
		driver.findElement(By.id("nav-credentials-tab")).click();
		testNote.threadSleepSeconds(2);
		// write separate get method for each, analogous to note
		assertEquals("testurl",testCredential.getUrl());
		assertEquals("testusername",testCredential.getUsername());
		assertNotEquals("testpassword",testCredential.getPassword());
	}

	@Test
	public void editCredential(){
		doMockSignUp("EditCredential","Test","EC","123");
		doLogIn("EC", "123");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 22);
		driver.findElement(By.id("nav-credentials-tab")).click();
		String url = "testUrl";
		String username = "testUsername";
		String password = "testPassword";
		testCredential.editCredential(url, username, password);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-credentials-tab")));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("nav-credentials-tab")));
		driver.findElement(By.id("nav-credentials-tab")).click();
		testNote.threadSleepSeconds(2);
		assertEquals("newUrl",testCredential.getUrl());
		assertEquals("newUsername",testCredential.getUsername());
		assertNotEquals("newPassword",testCredential.getPassword());
	}
	@Test
	public void deleteCredential(){
		doMockSignUp("DeleteCredential","Test","DC","123");
		doLogIn("DC", "123");
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-credentials-tab")));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("nav-credentials-tab")));
		driver.findElement(By.id("nav-credentials-tab")).click();
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("addANewCredentialButton")));
		testCredential.addCredential("testurl", "testusername", "testpassword");
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-credentials-tab")));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("nav-credentials-tab")));
		driver.findElement(By.id("nav-credentials-tab")).click();
		testNote.threadSleepSeconds(2);
		testCredential.deleteCredential();
		assertEquals(0, testCredential.getCountOfCredentials());
	}



}
