package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

    // Thread-safe WebDriver for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return driver.get();
    }
    public static String getBrowserName() {
        return browserName.get();
    }
    @Parameters("browser") // which browser to run
    @BeforeMethod // Runs before every test method to set up the browser.
    public void setup(@Optional("chrome") String browser) {
        WebDriver drv;

        switch (browser.toLowerCase()) {
            case "firefox":
            	System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\geckodriver-v0.36.0-win32\\geckodriver.exe");
                drv = new FirefoxDriver();
                break;
            case "edge":
            	System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                drv = new EdgeDriver();
                break;
           
            default:
            	WebDriverManager.chromedriver().setup();
                drv = new ChromeDriver();
                break;
        }

        drv.manage().window().maximize();
        drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        drv.get("https://in.bookmyshow.com"); 

        driver.set(drv);  
        browserName.set(browser);
        System.out.println(browser + " browser launched.");
    }

    @AfterMethod //Runs after every test method to close the browser.
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            browserName.remove();        
        }
    }
}
