import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedLocators 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
//Id Locator
		driver.findElement(By.id("inputUsername")).sendKeys("Samplemail123@gmail.com");
		
		//Name Locator
		driver.findElement(By.name("inputPassword")).sendKeys("p@ssW0rd");
		
		//Class Name Locator --> you can use 1 of any value of the class name
		//driver.findElement(By.className("submit")).click();
		driver.findElement(By.className("signInBtn")).click();
		//driver.findElement(By.className("submit signInBtn")).click();
		
		//CSS Selector Locator --> Class name = tagname.classname; Id = tagname#id; Generic = tagname[attribute='value']
		//You can verify your xpath in console using $('p.error')
		//CSS Selector using Class name
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//Link Text Locator --> tagname 'a' means anchor and you can use Link Text as locator
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(2000); //Added this code to give 2 sec wait because the UI has view transition happening
		//Xpath Locator --> //tagname[@attribute='value']
		//You can verify your xpath in console using $x('//input[@placeholder="Name"')
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Gon Freecs");
		
		//CSS Selector Locator --> customized / generic syntax
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("gonxfreecs00@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear(); //Clearing the value inputted in the field
		
		//Xpath Locator accessing the index
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("adultgon99@gmail.com");

		//**CSS Selector Locator accessing the index**
		//driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("cssSelector123@gmail.com");
		
		//Xpath locator traverse concept using parent child tags and index if there are no available attribute
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8-7000");
		
		//CSS Selector Locator (attribute value is different to each other) --> can use this approach
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//CSS Selector Locator parent-child traverse concept
		System.out.println(driver.findElement(By.cssSelector("form p[class$='infoMsg']")).getText());		
		
		//--Advanced Locators--
		
		//Xpath Locator --> Customized syntax that traverse from parent to child
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		//CSS Selector Locator --> using #id (without adding tagname)
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Chickenjockey2015");
		
		//CSS Selector Locator --> Check all attribute that contains the indicated value (partial text)
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		Thread.sleep(2000); 
		//Added this code to give 2 sec wait because the UI has view transition happening again 
		//Common error that can be encountered is "element click intercepted"
		
		driver.findElement(By.id("chkboxOne")).click();
		
		//Xpath Locator --> Check all attribute that contains the indicated value (partial text)
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}
}
