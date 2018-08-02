package Pages.Automation;

import Pages.BasePage;

public class LogInPage extends BasePage{
	

	//Login authentication page
	public void testLogIn1()
	{
		clickObject(login_button,cs,true);
	}
	//Login section, login with invalid account
	public void testLogIn2()
	{
		sendKeys("email",id,true,"monica");
		sendKeys("passwd",id,true,"monica");
		clickObject("#SubmitLogin",cs,true);
	}

	//Login section, with valid account, check for login and username
	public void testLogIn3()
	{
		sendKeys("email",id,true,username);
		sendKeys("passwd",id,true,password);
		clickObject("#SubmitLogin",cs,true);
	}
	
	//log out
	public void testLogOut()
	{
		clickObject(".logout",cs, true);
	}

}
