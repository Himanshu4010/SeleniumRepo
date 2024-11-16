package AssignmentMavenBikes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DucatiTest {
	@Test
	 public void ducati() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.bikewale.com/ducati-bikes");
		Reporter.log("Ducati bike race on hill areas",true);
	}

}
