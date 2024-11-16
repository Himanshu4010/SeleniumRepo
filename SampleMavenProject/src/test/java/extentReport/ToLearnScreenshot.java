package extentReport;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ToLearnScreenshot {
	@Test
	public void addScreenshot() throws InterruptedException {
		String time = LocalDateTime.now().toString().replace(":", "-");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.shoppersstack.com");
		
		//Thread.sleep(3000);
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String photo = ts.getScreenshotAs(OutputType.BASE64);
		
		// step 1: create an instance of extentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/"+time+"screenshotReport.html");
		
		//optional
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setDocumentTitle("Extent report");
		
		// step 2: create an instance of ExtentReports
		ExtentReports extReport=new ExtentReports();
		
		// step 3: attach an instance of extentSparkreport to extentReports
		extReport.attachReporter(spark);
		
		// step 4: create an instance of ExtentTest
		ExtentTest test = extReport.createTest("addScreenshot");
		
		// step 5: call log() to provide the status and log message
		test.log(Status.PASS, "adding screenshot into report");
		test.addScreenCaptureFromBase64String(photo);
		
		
		// step 6: call flush() to write message into destination
		extReport.flush();
	}

}
