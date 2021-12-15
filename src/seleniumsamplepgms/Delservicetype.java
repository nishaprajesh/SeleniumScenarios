package seleniumsamplepgms;

/*Access the url and enter Admin/Admin123 as credentials
Select the ‘Inpatient Ward’.
click on Login.
Navigate to Appointment Scheduling->Manage Service Types.
Click on Delete icon to perform deletion of Service Type.
Finding an xpath for Yes button results in multiple matching nodes.
Even though we applying indexing to identify the ‘Yes’ Button its not working.
*/
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Delservicetype {
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","ChromeDriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/appointmentschedulingui/manageAppointmentTypes.page");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.xpath("//form[@id='login-form']")).submit();
		boolean result = deleteServiceType("Dermatology");
		System.out.println(result);
	}
	public static boolean deleteServiceType(String serviceName) throws InterruptedException
	{
		boolean result = false;
		driver.findElement(By.xpath("//td[text()='"+serviceName+"']/following-sibling::td[3]/descendant::i[@title='Delete']")).click();
		List<WebElement> buttonList = driver.findElements(By.xpath(".//*[@id='delete-appointment-type-dialog']/div[2]/button[@class='confirm right']"));
		System.out.println("Number of Buttons" + buttonList.size());
		for(int i = 0;i<buttonList.size();i++)
		{
			try{
				if(buttonList.get(i).isDisplayed() || buttonList.get(i).isEnabled())
				{
					buttonList.get(i).click();
					result= true;
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("Element is not visible|| enabled"+e.getMessage());
			}
		}
		return result;
	}
}