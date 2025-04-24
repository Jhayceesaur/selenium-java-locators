import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ParsingString 
{
	public static void main(String[] args) throws InterruptedException 
	{
		String username = "Chickenjockey2015";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		String password = getPassword(driver);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello " + username + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException 
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Gon Freecs");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("gonxfreecs00@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8-7000");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordTxt = driver.findElement(By.cssSelector("form p[class$='infoMsg']")).getText();
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray1 = passwordTxt.split("'");
		String password = passwordArray1[1].split("'")[0];
		return password;
		//0 index = Please use temporary password 
		//1st index = rahulshettyacademy' to Login.
		
		//0 index = rahulshettyacademy
		//1st index =  to Login.
	}
}
