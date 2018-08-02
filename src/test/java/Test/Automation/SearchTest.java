package Test.Automation;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import Pages.Automation.SearchPage;
import Test.TestBase;

public class SearchTest extends TestBase {

	@Test
	public void testSearch()
	{
		SearchPage searchPage = new SearchPage();
		searchPage.testSearch1();
		assertEquals(getValue(".//*[@id='center_column']/h1/span[1]",xp,true,"text"),"\""+"DRESS"+"\"");
	}
}
