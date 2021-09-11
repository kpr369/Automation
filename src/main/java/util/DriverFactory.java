package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * This is class creates the WebDriver Instance
 */
public class DriverFactory {

    public final static Supplier<WebDriver> CHROME = ()-> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        return driver;
    };
    public final static  Supplier<WebDriver> FIREFOX = ()->
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        return driver;
    };

    public final static  Supplier<WebDriver> EDGE = ()->
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        return driver;
    };

    public static WebDriver getDriver(BrowserType browser)
    {
       return MAP.get(browser).get();
    }

    public final static Map<BrowserType,Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);

   static {
        MAP.put(BrowserType.CHROME,CHROME);
        MAP.put(BrowserType.FIREFOX,FIREFOX);
        MAP.put(BrowserType.EDGE,EDGE);
    }
}
