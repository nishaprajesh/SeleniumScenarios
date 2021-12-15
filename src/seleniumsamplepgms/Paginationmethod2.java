package seleniumsamplepgms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*Go to URL https://datatables.net/examples/advanced_init/dt_events.html
 * Print all the names from the table
 * Get the count of the name and compare with the captured names 
 */
public class Paginationmethod2 {
	String nextbuttonclassname;
	int listsize;
		@Test
		public void pagination2() throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://datatables.net/examples/advanced_init/dt_events.html");	
			
			List<String> names= new ArrayList<String>();
			/*List<WebElement> nameele=driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
			for(WebElement var:nameele){
				System.out.println("\n Names: "+var.getText());
				//add the names to the names list
				names.add(var.getText());
			}*/
			getname(driver,names);
        nextbuttonclassname=driver.findElement(By.xpath("//a[@id='example_next']")).getAttribute("class");			
			
			while(!nextbuttonclassname.contains("disabled"))
			{
			 driver.findElement(By.xpath("//a[@id='example_next']")).click();
			 listsize= getname(driver,names);
			 nextbuttonclassname=driver.findElement(By.xpath("//a[@id='example_next']")).getAttribute("class");
			}
			
			System.out.println("listsize"+listsize);
	}

		public int getname(WebDriver driver,List<String> names) 
		{
		List<WebElement> nameele=driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
		 for(WebElement var:nameele){
			System.out.println("\n Names: "+var.getText());
			//add the names to the names list
			names.add(var.getText());
		  }
		 return names.size();
		}
}
