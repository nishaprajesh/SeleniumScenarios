package seleniumsamplepgms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicwebtable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//to print all elements from column 
		//List<WebElement>tabledata=driver.findElements(By.cssSelector("#customers>tbody>tr>td:nth-child(1)"));
		//for (WebElement e : tabledata)
		//{
		//	System.out.println(e.getText());
		//}
			
		//print no of rows in table 
		
		List<WebElement>rowcount=driver.findElements(By.cssSelector("#customers>tbody>tr"));
		System.out.println(rowcount.size());
		//print no of columns in table 
		
		List<WebElement>colcount=driver.findElements(By.cssSelector("#customers>tbody>tr>th"));
		System.out.println(colcount.size());
		
		//tbody//tr[2]//td[1]  --> first row first col
		
		//print the entire table 
		
		for (int i=2;i<=rowcount.size();i++)
		{
			for(int j=1;j<=colcount.size();j++)
			{
				WebElement text=driver.findElement(By.xpath("//table[@id='customers']//tbody//tr["+i+"]//td["+j+"]"));
				System.out.println(text.getText());
				
			}
		}

}
}
