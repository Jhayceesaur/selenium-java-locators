import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathChildParentTraverse 
{
	public static void main(String[] args) 
	{
		//Absolute Xpath starts in parent tag or root (html) --> use single slash /html/head/body
		//Relative Xpath starts directly in the actual tag --> use double slash //button[@attribute='value']
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Traverse from Child back to Parent to Grand Parent
		//System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getText());
		
		//Traverse from Child back to Parent to Grand Parent back to Child
		//System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a")).getText());

		//Traverse from Parent to Child to Sibling back to Parent then Child
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		//Note: In CSS Selector, you cannot traverse from child to parent
		//Note: CSS Selector executes faster than XPath
		
	}
}
