package Test.Automation;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import Pages.Automation.CartPage;
import Test.TestBase;


public class CartTest extends TestBase {
	
	
	//Login section, with valid account, check for login and username
	@Test
	public void testCart()
	{
		CartPage cartpage = new CartPage();
		cartpage.testCart1();
		assertEquals(driver.findElement(By.xpath(".//*[@id='product_1_1_0_83493']/td[1]/a/img")).isDisplayed(), true);
	}
	
}
