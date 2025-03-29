package userauthentication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTestCase {
	WebDriver driver;
	
	@BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bold-thread.com/");
        driver.manage().window().maximize();
	}
    //Open the login Page
	@Test
	public void testLogin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bold-thread.com/login");
		System.out.println("Title is "+driver.getTitle());
		driver.findElement(By.linkText("Sign up")).click(); 
		driver.findElement(By.id("username")).sendKeys("poonamkumari13501@gmail.com");
		driver.findElement(By.id("email")).sendKeys("poonamkumari13501@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("8699104352");
		driver.findElement(By.xpath("//input[@placeholder='Your Address']")).sendKeys("Jalandhar City");
		driver.findElement(By.id("password")).sendKeys("BoldThread@13");
		driver.findElement(By.id("password_confirmation")).sendKeys("BoldThread@13");
		driver.findElement(By.xpath("//button[contains(@class,'mt-2 px-4 py-2 bg-black text-white rounded-md')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter OTP']")).sendKeys("");
		driver.findElement(By.xpath("//button[contains(@class,'w-full flex justify-center py-3 px-4 border border-transparent text-sm font-medium rounded-lg text-white bg-black shadow-lg hover:bg-gray-800 focus:outline-none focus:ring-2 focus:ring-black focus:ring-offset-2 transition duration-150')]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bold-thread.com/"));
	}
	@Test
	public void testInvalidLogin() {
		driver.get("https://www.bold-thread.com/login");
		driver.findElement(By.id("email")).sendKeys("poonamkumari13501@gmail.com");
		driver.findElement(By.id("password")).sendKeys("wrongpassword123");
		driver.findElement(By.xpath("//button[contains(@class,'w-full flex justify-center py-3 px-4 border border-transparent text-sm font-medium rounded-lg text-white bg-black shadow-lg hover:bg-gray-800 focus:outline-none focus:ring-2 focus:ring-black focus:ring-offset-2 transition duration-150')]")).click();
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-red-500 text-sm mb-4 border border-red-300 bg-red-100 px-4 py-2 rounded-md']"));
	        Assert.assertTrue(errorMessage.isDisplayed(), "Password must be at least 8 characters long and contain at least one letter and one number is showing as a msg instead its showing 'Error message not displayed for invalid login!'");
	}
	
	@AfterClass
    public void tearDown() {
        driver.quit();
    }

}
