import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathParentChSiblingsTraverse 
{
	public static void main(String[] args) 
	{
		//Absolute Xpath starts in parent tag or root (html) --> use single slash /html/head/body
		//Relative Xpath starts directly in the actual tag --> use double slash //button[@attribute='value']
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Traverse from Parent -> Child -> Sibling to sibling
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
	}
}
