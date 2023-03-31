package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AjioAui {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	options.addArguments("--remote-allow-origins=*");	
	ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://www.ajio.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("//span[contains(text(),'100%')]"));
	Actions builder = new Actions(driver);
	builder.scrollToElement(element).perform();
	System.out.println("Scroll to desired element is done");
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./snaps/ajioscroll.png");
	FileUtils.copyFile(source, dest);

	}

}
