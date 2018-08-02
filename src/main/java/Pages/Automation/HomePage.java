package Pages.Automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Pages.BasePage;

public class HomePage extends BasePage {
	
	
	
	
	public int homeTest1()
	{
		findObject("search_query_top",id,true);
		sendKeys("search_query_top", id, true ,"Dress");
		findObject(".//*[@id='authentication']/div[2]/ul/li",xp,true);
		List<WebElement> elements = null;
		int wrong=0;
		elements = driver.findElements(By.xpath(".//div[@class=\"ac_results\"]/ul/li"));
		for (WebElement element : elements)
		{
			if(!element.getText().toString().contains("Dress"))
			{
				wrong++;
				System.out.println("No Drees word in "+element.getText());
			}
		}

		return wrong;
	}
}
