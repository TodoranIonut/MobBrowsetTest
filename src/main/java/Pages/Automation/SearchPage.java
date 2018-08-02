package Pages.Automation;

import Pages.BasePage;

public class SearchPage extends BasePage{
	
	//Login section, with valid account, check for login and username
	public void testSearch1()
	{
		clickObject("search_query_top",id,true);
		sendKeys("search_query_top",id,true,"Dress");
		clickObject(".btn.btn-default.button-search",cs,true);
	}
	
}
