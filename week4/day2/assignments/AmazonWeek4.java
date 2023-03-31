package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonWeek4 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
	String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
	System.out.println("Price of 1st product is: " + price);
	Thread.sleep(2000);
	
	String rating = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
	System.out.println("No.of ratings for the 1st product is: " + rating);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
	
	//String parentWindow = driver.getWindowHandle();
	Set<String> childWindow = driver.getWindowHandles();
	List<String> child = new ArrayList<>(childWindow);
	driver.switchTo().window(child.get(1));
	
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./snaps/amazon-oneplus.png");
	FileUtils.copyFile(source, dest);
	
	driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
	String subTotal = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']/span")).getText();
	
	//String replaceAll = subTotal.replaceAll(",", " ");
	System.out.println("Cart Subtotal: " + subTotal);
	
	Thread.sleep(2000);
	driver.quit();
	

	}

}
