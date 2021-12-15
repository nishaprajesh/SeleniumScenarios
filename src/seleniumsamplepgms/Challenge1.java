package seleniumsamplepgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*1) go to this url -https://www.zoopla.co.uk/
2) Input location London and click submit
3) You will get a list of properties on that page. 
4) Print all the price values in sorted order (descending order) on the console
5) select the 5th property on that list (its changing every minute, so it’s dynamic) 
6) On the next page, there is a logo, name and telephone no of the agent. I need to click on the name link to get into the agent’s page.
7) Once on that page, I need to check that the the properties listed there belong to the same mentioned agent on the page.
*/
public class Challenge1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//go to this url -https://www.zoopla.co.uk/
		driver.get("https://www.zoopla.co.uk/");
		// Input location London and click submit
		driver.findElement(By.id("header-location")).sendKeys("London");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//button[text()='Search']")).click();
		
		//
		List<WebElement> price=driver.findElements(By.xpath("//div[contains(@class,'PriceContainer')]//p[not(contains(@class,'PriceTitleText'))]"));
		List<Double> pricelist= new ArrayList<>();
		for(WebElement e : price)
		{
			String test= e.getText().replace("£", "");
			
			pricelist.add(Double.valueOf(test.replace(",", "")));
			
			
		}
		// Print all the price values in sorted order (descending order) on the console
		Collections.sort(pricelist,Collections.reverseOrder());
		System.out.println(pricelist);
		
		driver.findElement(By.xpath("(//div[contains(@class,'PriceContainer')]//p[not(contains(@class,'PriceTitleText'))])[5]")).click();
		Thread.sleep(3000);
		
		String Agntname=driver.findElement(By.xpath("//p[contains(@class,'Text-AgentName')]")).getText();
		driver.findElement(By.xpath("//div[contains(@class,'AgentNameBlock')]/child::a")).click();
		Thread.sleep(3000);
		
		//phone number check 
		String agentphoneexpected=driver.findElement(By.cssSelector("div[class='agent_address'] p a")).getText();
		
		List<WebElement> phonenos=driver.findElements(By.cssSelector("div[class='listing-results-right'] span:nth-child(1)"));
				boolean phonecheck=true;
		for(WebElement chk : phonenos)
		{
			
			String replacestar =chk.getText().replace("*", "");
			phonecheck=(replacestar.replaceAll("\\s+","")).equals(agentphoneexpected.replaceAll("\\s+",""));
		}
			
		Assert.assertEquals(phonecheck, true);
		System.out.println("Agent Phone no match:"+phonecheck);
		
		
		//Agent name check 
		boolean agntcheck=true;
		List<WebElement> agentnames=driver.findElements(By.cssSelector("div[class='listing-results-left'] span"));
		for(WebElement chk2 : agentnames)
		{
			String raw_agent_name=chk2.getText();
			agntcheck=(raw_agent_name.split(","))[0].equals(Agntname);
		}
		
		Assert.assertEquals(agntcheck, true);
		System.out.println("Agent match:"+agntcheck);
	}

}
