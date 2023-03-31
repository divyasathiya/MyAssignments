package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://www.snapdeal.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	WebElement mens = driver.findElement(By.xpath("//span[@class='catText']"));
	Actions builder = new Actions(driver);
	builder.moveToElement(mens).perform();
	
	driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
	String tot = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
	String t1 = tot.replaceAll("[(  )]", " ");
	System.out.println("Count of the Sports Shoes are: "+ t1);
	
	driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	String before = driver.findElement(By.xpath("//span[contains(@class,'lfloat product-price')]")).getText();
	System.out.println(before);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//i[contains(@class,'sd-icon sd-icon-expand-arrow sort-arrow')]")).click();
	driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
	Thread.sleep(2000);
	String after = driver.findElement(By.xpath("//span[contains(@class,'lfloat product-price')]")).getText();
	System.out.println(after);
//	List<WebElement> price = driver.findElements(By.xpath("//span[contains(@class,'lfloat product-price')]"));
//	String[] pri = new String[price.size()];
//	int i=0;
//	
//	for (WebElement val:price) 
//	{
//		pri[i] = val.getText();
//		i++;
//		System.out.println(pri[i]);
//	}
//	
//	int [] len = new int[pri.length];
//	String str = null;
//	for (int j = 0; j < len.length; j++)
//	{
//		str = pri[j].replaceAll("Rs. "," ");
//		len[j]= Integer.parseInt(str);
//		System.out.println(len[j]);
//	}
	if (before.equals(after)) 
	{
		System.out.println("Sports shoes are not sorted ");
	}
	else {
		System.out.println("Sports shoes are sorted from low to high prices");
	}
	
	driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
	driver.findElement(By.xpath("//input[@name='toVal']")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
	driver.findElement(By.xpath("//div[@class='filter-inner']/div[5]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();

	
	List<WebElement> elements = driver.findElements(By.xpath("//div[@class='filters']"));
	List<String> sel = new ArrayList<String>();
	for (WebElement e:elements)
	{
		sel.add(e.getText());
	}
	System.out.println(sel);
	
	WebElement img = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
	builder.moveToElement(img).perform();
	driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();
	
	Thread.sleep(3000);
	String price = driver.findElement(By.xpath("//span[contains(@class,'payBlkBig')]")).getText();
	String discount = driver.findElement(By.xpath("//span[contains(@class,'percent-desc ')]")).getText();
	System.out.println("Discounted price is : "+ price+ " Discount rate is : " + discount);
	
	File source = driver.getScreenshotAs(OutputType.FILE);
	File Dest = new File("./snaps/snapdeal.png");
	FileUtils.copyFile(source, Dest);
	
	driver.findElement(By.xpath("//div[contains(@class,'close close1 marR10')]")).click();
	driver.close();

	}

}
