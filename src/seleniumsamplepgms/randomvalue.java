package seleniumsamplepgms;

import java.awt.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/* 
 * Go to 
 */

public class randomvalue {
	@Test
	public void randomsel(){
	System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Register.html");	
	//WebElement skillsdd=
	
	Select skill=new Select(driver.findElement(By.id("Skills")));
	
	//find the number of options 
int count=driver.findElements(By.xpath("//select[@id='Skills']/option")).size();
//Use random class in java
	Random random =new Random();
	skill.selectByIndex(random.nextInt(count));
	System.out.println("Randon no: "+random);
	
	

	}
}
