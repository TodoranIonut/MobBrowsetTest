package Test.Automation;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import Pages.Automation.LogInPage;
import Test.TestBase;

public class LogInTest extends TestBase{
	
	@Test
	public void testLogIn()
	{
		LogInPage loginPage = new LogInPage();
		loginPage.testLogIn1();
		assertEquals(getValue(".navigation_page",cs,true,"text") , "Authentication");
		loginPage.testLogIn2();
		assertEquals(getValue(".alert.alert-danger>ol>li",cs,true,"text") , "Invalid email address.");
		loginPage.testLogIn3();
		assertEquals(getValue(".account>span",cs,true,"text") , "Monica Pop");
		loginPage.testLogOut();
	}
}
