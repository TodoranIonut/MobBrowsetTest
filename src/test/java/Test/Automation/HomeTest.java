package Test.Automation;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import Pages.Automation.HomePage;
import Test.TestBase;

public class HomeTest extends TestBase{

	
	@Test
	public void testHome()
	{
		HomePage homepage = new HomePage();
		assertEquals(homepage.homeTest1(),0);		
	}
}
