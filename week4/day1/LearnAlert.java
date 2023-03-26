package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		// Loads a new web page in the current browser window
		// Maximize the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		Thread.sleep(2000);
		Alert altSimple = driver.switchTo().alert();
		String text = altSimple.getText();
		System.out.println("Alert message is:" + text);
		altSimple.accept();
		String mess = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		if (mess.contains("success")) {
			System.out.println("Alert is handled for Simple Dialog");
		}
		else {
			System.out.println("Alert is not handled for Simple Dialog");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		Alert alt = driver.switchTo().alert();
		String altText = alt.getText();
		System.out.println("Alert message is:" + altText );
		
		alt.accept();
		String msg = driver.findElement(By.xpath("//span[@id='result']")).getText();
		if (msg.contains("Clicked")) {
			System.out.println("Alert is handled for Confirm Dialog");
		}
		else {
			System.out.println("Alert is not handled for Confirm Dialog");
		}
	}

}
