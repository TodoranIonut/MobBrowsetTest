package Pages.Softvision;

import Pages.BasePage;

public class MenuPage extends BasePage{

	public void testMenuButtonsDisplayed()
	{
		clickObject("#hs-eu-confirmation-button",cs,true);
		clickObject(".hamburger-box",cs,true);
	}
}
