package extentReport;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AssignmentVerifyDemowbShopExtentRport {
	@Test
	public void verifyLogin() {

		String time = LocalDateTime.now().toString().replace(":", "-");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_report/" + time + "screenshotReport.html");
		ExtentReports extReport = new ExtentReports();
		extReport.attachReporter(spark);

		driver.get("https://demowebshop.tricentis.com");
		if (driver.getCurrentUrl() == "https://demowebshop.tricentis.com") {
			System.out.println("welcome page is displayed");
		}
		driver.findElement(By.partialLinkText("Log in")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Demo Web Shop. Login")) {
			System.out.println("loginlink page displayed");

		} else {
			System.out.println("loginlink page not displayed");
		}
		
		ExtentTest test = extReport.createTest("AssignmentVerifyDemowbShopExtentRport");
		driver.findElement(By.id("Email")).sendKeys("abhis1234@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("abhis@1234");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		String title1 = driver.getTitle();
		System.out.println(title1);
		if (title1.equals("Demo Web Shop")) {
			System.out.println("Home page is displayed");
		} else {
			System.out.println("home page is not displayed");
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		String screenShot = ts.getScreenshotAs(OutputType.BASE64);

		test.log(Status.PASS, "adding screenshot into report");
		test.addScreenCaptureFromBase64String(screenShot);
		
		extReport.flush();

	}

}
