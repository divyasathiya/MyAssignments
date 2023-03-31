package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IrctcSnapshot {

	public static void main(String[] args) throws InterruptedException, IOException {
			
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
		File source = driver.getScreenshotAs(OutputType.FILE);
		File desti = new File("./snaps/flights.png");
		FileUtils.copyFile(source, desti);
		System.out.println("Screenshot is taken");

	}

}
