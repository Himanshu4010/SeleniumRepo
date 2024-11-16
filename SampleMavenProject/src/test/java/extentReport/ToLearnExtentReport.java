package extentReport;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport {
	@Test
	public void report() {
	String time = LocalDateTime.now().toString().replace(":", "-");
		// step 1: create an instance of extentSparkReporter
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_report/"+time+"extentReport.html");

		// step 2: create an instance of ExtentReports
		ExtentReports extReport = new ExtentReports();

		// step 3: attach an instance of extentSparkreport to extentReports
		extReport.attachReporter(spark);

		// step 4: create an instance of ExtentTest
		ExtentTest test = extReport.createTest("report");

		// step 5: call log() to provide the status and log message
		test.log(Status.PASS, "log message added into report");
		test.log(Status.INFO, "open browser");

		// step 6: call flush() to write message into destination
		extReport.flush();

	}

}
