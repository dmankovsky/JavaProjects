package mvc_basics.mvc_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import mvc_basics.mvc_basics.model.ChatMessage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MvcBasicsApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;

	public String baseURL;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll(){
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach(){
		//driver.get("http://localhost:" + port);
		baseURL = "http://localhost:" + port;
	}

	@Test
	public void testUserSignupLoginAndSubmitMessage() {
		String username = "dm1";
		String password = "password1";
		String messageText = "Hello!";

		driver.get(baseURL + "/signup");

		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup("dm1", "dm1", username, password);

		driver.get(baseURL + "/login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		ChatPage chatPage = new ChatPage(driver);
		chatPage.sendChatMessage(messageText);

		ChatMessage sentMessage = chatPage.getFirstMessage();

		assertEquals(username, sentMessage.getUsername());
		assertEquals(messageText, sentMessage.getMessageText());
	}

}
