package seleniumsamplepgms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*Access the url  https://demo.openmrs.org/openmrs/login.htm
 * and enter Admin/Admin123 as credentials
Select the ‘Inpatient Ward’.
click on Login.
Navigate to Appointment Scheduling->Manage Service Types.
Write Selenium WebDriver Script to verify the Service Type ‘Urology’ available in the html table.
*/
public class Breakfromloop {
	@Test
	public void looptest() throws InterruptedException
	{
		boolean match;
		 WebElement Nextbtn;
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");	


		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul//li[@id='Inpatient Ward']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@id='appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='appointmentschedulingui-manageAppointmentTypes-app']")).click();
		Thread.sleep(2000);
		
		 match =false;
		 Nextbtn= driver.findElement(By.cssSelector("#appointmentTypesTable_next"));
		 String classnext=Nextbtn.getAttribute("class");
		 outerloop:
		 while (!classnext.contains("disabled")){
		 		List<WebElement> name= driver.findElements(By.cssSelector("#appointmentTypesTable>tbody>tr>td:nth-child(1)"));
		 		for(WebElement e:name){
		 			if(e.getText().equalsIgnoreCase("Neurology"))
		 			{
		 				System.out.println("Match found");
		 				match=true;
		 				break outerloop;
		 			}
		 		}
		
		 		driver.findElement(By.cssSelector("#appointmentTypesTable_next")).click();
		 		Nextbtn= driver.findElement(By.cssSelector("#appointmentTypesTable_next"));
		 		classnext=Nextbtn.getAttribute("class");
	   }
		
		
	}

}
