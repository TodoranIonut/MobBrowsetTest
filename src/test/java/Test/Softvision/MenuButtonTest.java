package Test.Softvision;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Pages.Softvision.*;
import Test.TestBase;

public class MenuButtonTest extends TestBase {
	
	@Test
	public void testMenuButtons()
	{
		System.out.println("Menu buttons Test START!");
		MenuPage buttons = new MenuPage();
		buttons.testMenuButtonsDisplayed();
		assertEquals(getValue(".//div[@class='social']/a[contains(@href,'linkedin')]",xp,true,"displayed"), "true");
		assertEquals(getValue(".//div[@class='social']/a[contains(@href,'twitter')]",xp,true,"displayed"), "true");
		assertEquals(getValue(".//div[@class='social']/a[contains(@href,'facebook')]",xp,true,"displayed"), "true");
		assertEquals(getValue(".//div[@class='social']/a[contains(@href,'instagram')]",xp,true,"displayed"), "true");
		System.out.println("Menu buttons Test COMPLETE!");
	}

}
