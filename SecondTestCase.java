package userauthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCase {
	WebDriver driver;
	
	@Test
	public void testAddToCart() {
		
		// Navigate to the cart and validate product name and quantity
		driver.findElement(By.xpath("//div[@class='text-white text-xs rounded-md p-2 bg-black w-full sm:w-auto']/button[1]"));
		WebElement productName = driver.findElement(By.xpath("//h2[@class='font-manrope font-bold text-3xl text-gray-900 mb-2']"));
	    WebElement productQuantity = driver.findElement(By.xpath("//div[@class='text-lg']"));
	    
	    Assert.assertEquals(productName.getText(), "Solid Orange T-Shirt");
	    Assert.assertEquals(productQuantity.getAttribute("value"),"1");
	}

}
