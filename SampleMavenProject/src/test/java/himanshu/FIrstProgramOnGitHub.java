package himanshu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FIrstProgramOnGitHub {
	@Test
	public void display()
	{
		WebDriver driver =new ChromeDriver();
		driver.get("www.fikfap.com");
		Reporter.log("After navigating to this url mooth maring is compulsory",true);
	}
	

}
