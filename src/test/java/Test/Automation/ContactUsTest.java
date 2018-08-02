package Test.Automation;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import Pages.Automation.ContactUsPage;
import Test.TestBase;

public class ContactUsTest extends TestBase{

	@Test
	public void testContactUs()
	{
		ContactUsPage contactpage = new ContactUsPage();
		contactpage.testContact1();
		assertEquals(getValue(".alert.alert-danger>ol>li",cs,true,"text"), "Invalid email address.");
	}
}
