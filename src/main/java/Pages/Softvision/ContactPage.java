package Pages.Softvision;

import Pages.BasePage;

public class ContactPage extends BasePage{


	public void testContactPage()
	{		
		clickObject("#hs-eu-confirmation-button",cs,true);
		clickObject(".hamburger-box",cs,true);
		clickObject("#nav-menu-item-19896>a",cs,true);
	}
}
