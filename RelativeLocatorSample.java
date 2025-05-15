import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*; //Manually import this package to use relative locators

import org.openqa.selenium.By;

public class RelativeLocatorSample 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Relative Locator Above
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		//Relative Locator Below
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		//Relative Locator Left
		WebElement chckBox = driver.findElement(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(chckBox)).click();
		
		//Relative Locator Right
		WebElement empStatusRdBtn = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(empStatusRdBtn)).getText());
	}
}
