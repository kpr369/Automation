package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import util.BrowserType;
import util.DriverFactory;

public class TestBase {

    public WebDriver driver;
    @BeforeMethod
    public void beforeMyEachMethod(ITestResult result)
    {
        System.out.println(result.getMethod().getMethodName()+ "Execution Started");
        driver = DriverFactory.getDriver(BrowserType.CHROME);
    }
}
