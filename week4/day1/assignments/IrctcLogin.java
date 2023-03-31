package week4.day1.assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IrctcLogin {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[contains(@aria-label,'Menu Flight')]")).click();
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles.size());
//		for (String tab : handles) {
//			System.out.println(tab);
//		}
		List<String> li = new ArrayList<>(handles);
		driver.switchTo().window(li.get(1));
		System.out.println(driver.getTitle());
		
	}

}
