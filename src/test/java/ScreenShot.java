import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		
		System.out.println(System.getProperty("user.dir"));
		WebElement google = driver.findElement(By.cssSelector("#hplogo"));
		File source = google.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"\\screenshots\\google.png");
		FileHandler.copy(source, destination);
		
		driver.quit();
		
	}

}
