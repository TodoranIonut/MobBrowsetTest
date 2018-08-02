package Pages.Automation;

import Pages.BasePage;

public class ContactUsPage extends BasePage {
	
	//Contact Us section, press submit button without email, display error message
	public void testContact1()
	{

		clickObject("#contact-link>a",cs,true);
		clickObject("submitMessage",id,true);
	}
}
