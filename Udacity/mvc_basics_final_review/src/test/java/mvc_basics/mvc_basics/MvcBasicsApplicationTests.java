package mvc_basics.mvc_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MvcBasicsApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private SignupPage signup;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll(){
		driver.quit();
	}

	@BeforeEach
	public void beforeEach(){
		driver.get("http://localhost:" + port + "/signup");
		signup = new SignupPage(driver);
	}

	@Test
	public void testSignup(){
		signup.enterFirstName("testFirstName");
		signup.enterLastName("testLastName");
		signup.enterUserName("testUserName");
		signup.enterPassword("testPassword");

	}

}
