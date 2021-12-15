package seleniumsamplepgms;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Go to URL https://datatables.net/examples/advanced_init/dt_events.html
 * Print all the names from the table
 * Get the count of the name and compare with the captured names 
 */
public class Paginationmethod1 {
	

	@Test
	public void pagination1() throws InterruptedException {
	/*capture names from first page
	 * click on second print names and so on
	 */
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");	
		
		// get the count of the pages
		int pagesize=driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		//define an empty list to add names of from each page
		
		List<String> names= new ArrayList<String>();
		for (int i=1;i<=pagesize;i++){
			driver.findElement(By.cssSelector("#example_paginate>span>a:nth-child("+i+")")).click();
			Thread.sleep(2000);
			
			//#example>tbody>tr>td:nth-child(1)
			List<WebElement> nameele=driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
			for(WebElement var:nameele){
				System.out.println("\n Names: "+var.getText());
				//add the names to the names list
				names.add(var.getText());
			}
			
			}
		int count=names.size();
		//Get the count from the screen Showing 1 to 10 of 57 entries
		String countfromgui=driver.findElement(By.id("example_info")).getText().split(" ")[5];
		System.out.println("Count from the Array list" +count);
		System.out.println("Count from the GUI" +countfromgui);
				
		Assert.assertEquals(countfromgui, String.valueOf(count));
		
		
		
	}
}
