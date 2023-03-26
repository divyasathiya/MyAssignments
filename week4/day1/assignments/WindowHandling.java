package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		String pTitle = driver.getTitle();
		String parent = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		//t size = childWindow.size();
		List<String> win = new ArrayList<>(childWindow);
		driver.switchTo().window(win.get(1));
	  
	    String cTitle = driver.getTitle();
	    if (pTitle.equals(cTitle)) {
			System.out.println("Control stays in the same page");
		}
	    else {
	    	System.out.println("Control switched to the new Window");
	    }
	    //driver.close();
	    driver.switchTo().window(parent);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
	    System.out.println("Total no.of opened tabs:" + childWindow.size());
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
	    
	    for (String multiple : childWindow) {
			if (!multiple.equals(parent)) {
				driver.switchTo().window(multiple);
				driver.close();
			}
			System.out.println("All windows are closed");
			driver.switchTo().window(parent);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
			Thread.sleep(3000);
			
	    }
			
		}

	}


