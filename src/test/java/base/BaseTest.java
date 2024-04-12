package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import page.SignupPage;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver;
    protected SignupPage signupPage;
    protected ExtentSparkReporter spark;
    protected ExtentReports extent;
    protected static ExtentTest test ;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        spark = new ExtentSparkReporter("Automation Test Report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    @BeforeMethod
    public void goToSignupPage() {
        driver.get("https://codenboxautomationlab.com/registration-form/");
        signupPage = new SignupPage(driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            extent.createTest(result.getMethod().getMethodName()).fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
        }
    }
    public String captureScreenshot(String methodName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir") + "/Screenshots/" + methodName + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            return dest;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    @AfterSuite
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
        driver.close();
    }
}
