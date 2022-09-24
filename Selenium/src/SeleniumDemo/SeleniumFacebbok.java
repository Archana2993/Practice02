package SeleniumDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class SeleniumFacebbok {
	

	public static void main(String[] args) throws IOException
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss");
		LocalDateTime dateAndtime= LocalDateTime.now();
		String datetime =dtf.format(dateAndtime);	
		System.setProperty("webdriver.chrome.driver","D:\\Sotware tesing\\Selenium\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement  logo=driver.findElement(By.xpath("//img[@alt='Facebook']"));
		WebElement  page=driver.findElement(By.xpath("//div[@class='mbs _52lq _9bp_ fsl fwb fcb']"));
		boolean result=logo.isDisplayed();
		String text=page.getText();
		System.out.println(text);
		if(text.equals("Create a new account")&& result==true)
		{
			System.out.println(result+","+text);
			System.out.println("User should able to see Create New account page ");
		}
		else
		{
			System.out.println("Test case Fail");
		}
		String path ="C:\\Users\\Samir\\Desktop\\Credential.xlsx";
		FileInputStream file=new FileInputStream(path);
	    XSSFWorkbook w=new XSSFWorkbook(file);
		XSSFSheet s=w.getSheet("Login data");
		XSSFRow r=s.getRow(1);
		String name=r.getCell(0).getStringCellValue();
		String lastname=r.getCell(1).getStringCellValue();
		String mail=r.getCell(2).getStringCellValue();
		String pass=r.getCell(3).getStringCellValue();
	    WebElement  username=driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement  surname=driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement  email=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement  newPass=driver.findElement(By.xpath("//input[@id=\"password_step_input\"]"));
		WebElement  date=driver.findElement(By.xpath("//select[@id='day']"));
		WebElement  month=driver.findElement(By.xpath("//select[@id='month']"));
		WebElement  year=driver.findElement(By.xpath("//select[@id='year']"));
		WebElement  gender=driver.findElement(By.xpath("//label[text()='Female']"));
		WebElement  button=driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]"));
		username.sendKeys(name);
		surname.sendKeys(lastname);
		email.sendKeys(mail);
		newPass.sendKeys(pass);
		Select sd=new Select(date);
		sd.selectByValue("2");
		Select sm=new Select(month);
		sm.selectByValue("9");
		Select sy=new Select(year);
		sy.selectByValue("1996");
		gender.click();
		button.click();
		
		TakesScreenshot take= (TakesScreenshot) driver;
		File srce= take.getScreenshotAs(OutputType.FILE);
		File dest =new File("D:\\Sotware tesing\\ScreenShot\\Test1 "+datetime+".png");
		FileHandler.copy(srce, dest);
		
		
}
}
