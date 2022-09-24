package SeleniumDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumMakeMytrip {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Sotware tesing\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/accounts/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement logo=driver.findElement(By.xpath("//img[@class='s4Iyt']"));
		String s=logo.getAttribute("alt");
		System.out.println(s);
		WebElement button=driver.findElement(By.xpath("//button[@class='sqdOP  L3NKy   y3zKF     ']"));
		boolean result=button.isEnabled();
		System.out.println(result);
		if(result==false && s.contains("Instagram"))
		{
			System.out.println("Test Case pass");
		}
		else
		{
			System.out.println("Test Case fail");
		}
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys("archanashejul2@gmail.com");
		password.sendKeys("xyz@1236");
		button.click();
		WebElement errormsg=driver.findElement(By.xpath("//p[@data-testid='login-error-message']"));
		String error=errormsg.getText();
		System.out.println(error);
		if(error.equals("Sorry, your password was incorrect. Please double-check your password."))
		{
			System.out.println("Test Case pass");
		}
		else
		{
			System.out.println("Test Case fail");
		}
	}

}
