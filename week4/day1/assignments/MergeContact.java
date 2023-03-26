package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
//		driver.findElement(By.xpath("//input[@name='USERNAME']")).click();
//		driver.findElement(By.xpath("//input[@name='PASSWORD']")).click();
//		driver.findElement(By.xpath("//input[@class='loginButton']")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		
		for (String handle : driver.getWindowHandles())
		{
	        driver.switchTo().window(handle);
	        
		}
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[@class='linktext']")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
				for (String head : driver.getWindowHandles())
		{
	        driver.switchTo().window(head);
	       
		}
		
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]//a")).click();
		 Thread.sleep(2000);
		 driver.switchTo().window(parent);
	     driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Thread.sleep(2000);
		
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		System.out.println(text);
		alt.accept();
		String head = driver.getTitle();
		System.out.println("Title of the page is: " + head);
	}

}
