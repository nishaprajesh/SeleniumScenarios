package seleniumsamplepgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/* Test case
 * Go to URL: https://www.saucedemo.com/
 * Filter Price "Low to high 
 * verify the results are in ascending order 
 */
public class Ascendingordercheck {
	//public static void main(String[] args) throws InterruptedException {
	@Test
	public static void verifyprice() throws InterruptedException {
		//1. Before filter capture the prices
		//2. filter the prices
		//3. after filter capture the prices and compare the values and assert
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");	
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		//1. Before filter capture the prices
		List<WebElement> beforefilterprice=driver.findElements(By.className("inventory_item_price"));
		//1.1 remove the $ symbol from the price and convert the string to double
		List<Double> beforefilterpricelist=new ArrayList<>();
		
		for(WebElement p:beforefilterprice) {
			beforefilterpricelist.add(Double.valueOf(p.getText().replace("$", "")));
			//remove $ -->p.getText().replace("$", "")
			//convert to double Double.valueOf(p.getText().replace("$", ""))
			//add to the new double list beforefilterpricelist.add
					
		}
		
		//2. Filter the value from the drop down
		Select dropdown=new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByVisibleText("Price (low to high)");
		
		//3. after filter capture the prices and compare the values and assert
		List<WebElement> afterfilterprice=driver.findElements(By.className("inventory_item_price"));
		
		//convert this to double , remove $ and add to another list 
		List<Double> afterfilterpricelist= new ArrayList<>();
		
		for(WebElement a :afterfilterprice){
			afterfilterpricelist.add(Double.valueOf(a.getText().replace("$", "")));
		}
		
		
		//before compare , sort the beforefilterpricelist .the afterfilterpricelist is already sorted by the application
		Collections.sort(beforefilterpricelist);
	
		//Compare the before and after 
	Assert.assertEquals(beforefilterpricelist, afterfilterpricelist);	
	System.out.println(beforefilterpricelist);
		Thread.sleep(3000);
		driver.quit();
		
	}
}
