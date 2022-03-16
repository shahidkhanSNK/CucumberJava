package StepsDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GRTLoginTest {

	WebDriver driver = null;

	@Given("user is on login page")
	public void user_on_login_page() {

		// To store this project's path
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);

		// To set the property for Google Chrome drive, without it, it will throw an error
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// To maximize the browser window
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		String baseUrl1 = "https://t1.grtinsight.com/"; 
		driver.get(baseUrl1);

		System.out.println("Inside 1st step");
	}

	@When("user enters valid (.*) and (.*)$")
	public void user_enters_userrname_and_password(String username, String password) throws InterruptedException {

		TimeUnit.SECONDS.sleep(5);
		WebElement email= driver.findElement(By.id("email"));;
        TimeUnit.SECONDS.sleep(2);
		//email.sendKeys("admin@grthealthonline.com");
        email.sendKeys(username);
		
		TimeUnit.SECONDS.sleep(2);
		
		// To find Password text area and then enter password
		WebElement pass = driver.findElement(By.id("password"));
		//password.sendKeys("@Grthealthadmin2021#");
		pass.sendKeys(password);
		
		TimeUnit.SECONDS.sleep(2);
	}

	@And("clicks on login button")
	public void clicks_login_button() throws InterruptedException {

		// To find and click Sign in button
				WebElement signin  = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]"));
				signin.click();
				TimeUnit.SECONDS.sleep(10);
	}

	@Then("user is navigated to dashboard")
	public void user_navigated_to_dashboard() {

		driver.getPageSource().contains("Device");
		driver.close();
		driver.quit();
	}

}
