package Test;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Pages.BasePage;


public class TestBase extends BasePage{

//	@BeforeSuite
//	public void setPlatform()
//	{
//		
//	}
	
	@Parameters({"platform"})
	@BeforeClass
	public void initSet(String platform) throws MalformedURLException
	{
		if(platform.equals("Desktop"))
			initSetB();
		else if(platform.equals("Mobile"))
			initSetDivice();
	}
	
	

	
	@AfterClass
	public void tearDown()
	{
		tearDownP();
	}

}
