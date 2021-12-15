package seleniumsamplepgms;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Dragdrop {

	//public static void main(String[] args) throws InterruptedException
	@Test
	public void dragdropcompare() throws InterruptedException{
/*Test case 
 * 1. open chrome browser
 * 2. Drag Loan amount to 75lkhs
 * 3. Drag interest rate to 12.5%
 * 4. Drag Loan Tenure to 15 years
 * Verify Loan EMI is 92,439
 */

		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://emicalculator.net");
		
		//	Maximize the Browser Window
		driver.manage().window().maximize();
		Actions actions=new Actions(driver);
		WebElement loanslider=driver.findElement(By.xpath("//div[@id='loanamountslider']//span"));
		WebElement intrateslider=driver.findElement(By.xpath("//div[@id='loaninterestslider']//span"));
		WebElement loantenslider=driver.findElement(By.xpath("//div[@id='loantermslider']//span"));
		
		actions.dragAndDropBy(loanslider, 83, 0).build().perform();
		Thread.sleep(2000);
		
		actions.dragAndDropBy(intrateslider, 88, 0).build().perform();
		Thread.sleep(2000);
		
		//negative value here because slide backward
		actions.dragAndDropBy(loantenslider, -111, 0).build().perform();
		Thread.sleep(2000);
	//Get the amount from loan EMI 
		String emi= driver.findElement(By.xpath("//div[@id='emiamount']//span")).getText();
	
		Assert.assertEquals(emi, "92,439");
		
		Thread.sleep(2000);
		if(emi=="92439")
		{
			System.out.println("EMI: "+emi+"Matching");
			
		}
		else
			System.out.println("Not matching");
		
		//Close all windows of Browser
		driver.quit();
	}

}

