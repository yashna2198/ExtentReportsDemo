package learning.ExtendReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtendReportsDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void Reports() {
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Report Demo");
		reporter.config().setDocumentTitle("Demo chart");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Yashna");		
		
	}
	
	@Test
	public void InitialDemo() {
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		test.fail("Results do not match***");
		System.out.println("****END***");
		System.out.println("****CARD***");
		System.out.println("*******");
		extent.flush();
	}

}
