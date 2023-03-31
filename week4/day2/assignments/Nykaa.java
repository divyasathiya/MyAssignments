package week4.day2.assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://www.nykaa.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Mouse hover on brands
	WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
	Actions builder = new Actions(driver);
	builder.moveToElement(brand).perform();
	
	//Select L'Oreal Paris
	driver.findElement(By.xpath("//a[contains(text(),'Paris')]")).click();
	String title = driver.getTitle();
	if(title.contains("L'Oreal Paris"))
	{
		System.out.println("Title is verified");
	}
	else {
		System.out.println("Title is not correct");
	}
	
//	WebElement cat = driver.findElement(By.xpath("//span[text()='Gender']"));
//	builder.scrollToElement(cat).perform();
//	Thread.sleep(2000);
	
	//Select category
	driver.findElement(By.xpath("//*[name()='svg' and @class='arrow-icon']")).click();
	driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']//span[text()='customer top rated']")).click();
	String sortName = driver.findElement(By.xpath("//span[contains(text(),'Sort By : customer top rated')]")).getText();
	System.out.println(sortName);
	Thread.sleep(2000);
	
	//select customer top rated
	driver.findElement(By.xpath("//div[@id='first-filter']//span[text()='Category']")).click();
	driver.findElement(By.xpath("(//span[@class='side-count'])[1]//*[name()='svg' and @class='arrow-icon']")).click();
	Thread.sleep(2000);
	
	//select hair, hair care, shampoo
	driver.findElement(By.xpath("(//span[@class='side-count'])[2]//*[name()='svg' and @class='arrow-icon']")).click();
	driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']/div[2]")).click();
	
	//select concern
	driver.findElement(By.xpath("//span[text()='Concern']/following::div/div/*[1]")).click();
	driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']/div[@class='control-indicator checkbox ']")).click();
	Thread.sleep(2000);
	
	//check filter is applied for shampoo
	
	List<WebElement> filter = driver.findElements(By.xpath("//span[@class='filter-value']"));
	List<String> listShamp = new ArrayList<String>();
	
	for (WebElement each : filter)
	{
		listShamp.add(each.getText());
	}
	
	System.out.println("Filter selected are :" + listShamp);
	
	if (listShamp.contains("Shampoo")) {
		System.out.println("Shampoo is in filter");
	}
	else 
	{
		System.out.println("Shampoo is not in filter");
	}
	
	//select L'Oreal shampoo
	driver.findElement(By.xpath("//a[@target='_blank']/div/img")).click();
	Set<String> Shampoo = driver.getWindowHandles();
	List<String> select = new ArrayList<>(Shampoo);
	driver.switchTo().window(select.get(1));
	
	driver.findElement(By.xpath("//button[@type='button']/span[text()='180ml']")).click();
	System.out.println("MRP of the product is:" + driver.findElement(By.xpath("//span[contains(text(),'MRP')]/following-sibling::span[1]")).getText());
	driver.findElement(By.xpath("(//button[@type='button']/span[@class='btn-text'])[1]")).click();
	driver.findElement(By.xpath("//button[@type='button']/*[name()='svg'][1]")).click();
	
	driver.switchTo().frame(0);
	String total = driver.findElement(By.xpath("(//span[@color=\"#001325\"])[2]")).getText();
	System.out.println("Grand Total of the product :" + total);	
	driver.findElement(By.xpath("//span[contains(text(),'Proceed')]/ancestor::button")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Continue as guest')]")).click();
	
	
	}

}
