import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import util.BrowserType;
import util.Constants;
import util.DriverFactory;

public class TestCase extends TestBase {

    @Test
    public void testJenkins()
    {
        driver.get(Constants.URL);
    }
}
