package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		System.out.println("Alert message is: " + text);
		
		alt.accept();
		
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("iframeResult");
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		if (text2.contains("pressed")) {
			System.out.println("Handled Simple Alert");
		}
		else {
			System.out.println("Alert not handled");
		}
	}

}
