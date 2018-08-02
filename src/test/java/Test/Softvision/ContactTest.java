package Test.Softvision;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import Test.TestBase;
import Pages.Softvision.ContactPage;

public class ContactTest extends TestBase{

	@Test
	public void testContact()
	{
		System.out.println("Contact Test START!");
		ContactPage contactpage = new ContactPage();
		contactpage.testContactPage();
		assertEquals(driver.getCurrentUrl(), "https://www.softvision.com/contact/");
		System.out.println("Contact Test COMPLETE!");
	}
}
