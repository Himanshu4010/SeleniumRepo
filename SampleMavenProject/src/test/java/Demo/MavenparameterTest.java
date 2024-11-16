package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenparameterTest {
	@Test
	public void recieveData() {
		 String url = System.getProperty("url");
		 String email = System.getProperty("email");
		 String pass = System.getProperty("pass");
		
		 
		 WebDriver driver=new ChromeDriver();
		 driver.get(url);
		 
		 driver.findElement(By.partialLinkText("Log in")).click();
		 driver.findElement(By.id("Email")).sendKeys(email);
		 driver.findElement(By.id("Password")).sendKeys(pass);
		 driver.findElement(By.xpath("//input[@value='Log in']")).click();
		 
//		 System.out.println(email);
//		 System.out.println(pass);
	}

}
