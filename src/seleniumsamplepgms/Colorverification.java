package seleniumsamplepgms;
/* Open chrome
 * go to http://a.testaddressbook.com/
 * sign in , click on address tab
 * Click on new address link 
 * Fill all the required fields
 * Click on create address button
 * verify the color 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Colorverification {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://a.testaddressbook.com/sign_in");
		driver.findElement(By.id("session_email")).sendKeys("nisha4test@g.com");
		driver.findElement(By.id("session_password")).sendKeys("test123");
		
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Addresses']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("New Address")).click();
		Thread.sleep(2000);
		//new address page
		driver.findElement(By.id("address_first_name")).sendKeys("testfirstname");
		Thread.sleep(1000);
		driver.findElement(By.id("address_last_name")).sendKeys("testlastname");
		Thread.sleep(1000);
		driver.findElement(By.id("address_street_address")).sendKeys("street");
		Thread.sleep(1000);
		driver.findElement(By.id("address_city")).sendKeys("city");
		Thread.sleep(1000);
		driver.findElement(By.id("address_zip_code")).sendKeys("11111");
		Thread.sleep(2000);
		//javascript executor for color
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("document.getElementById('address_color').value='#0433FF'");
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);
		
		//Verify if the color is saved as expected..> need updation here 
		String selcolor=driver.findElement(By.cssSelector("span[data-test='color'])")).getCssValue("background");
		System.out.println(selcolor);
	}
}
