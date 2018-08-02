package Pages.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


import Pages.BasePage;

public class CartPage extends BasePage{

	//Login section, with valid account, check for login and username
	public void testCart1()
	{

		clickObject(login_button,cs,true);
		sendKeys("email",id,true,username);
		sendKeys("passwd",id,true,password);
		clickObject("SubmitLogin",id,true);
		clickObject(".logo.img-responsive",cs,true);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector(".replace-2x.img-responsive"))).perform();
		//action.moveToElement(findObject(".replace-2x.img-responsive",cs,true)).perform();
		WebElement addToCartButton = driver.findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default>span"));
		//WebElement addToCartButton = findObject(".button.ajax_add_to_cart_button.btn.btn-default>span",cs,true);
		action.moveToElement(addToCartButton).click().build().perform();
		WebElement cartButton = driver.findElement(By.xpath(".//a[@title=\"View my shopping cart\"]"));
		//WebElement cartButton = findObject(".//a[@title=\"View my shopping cart\"]",xp,true);
		cartButton.click();
		clickObject(".shopping_cart>a",cs,true);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='product_1_1_0_83493']/td[2]/p/a")));
	}
}
