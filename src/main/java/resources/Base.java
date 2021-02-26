package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        String path = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(path + "\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\java\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("InternetExplorer")) {
            System.setProperty("webdriver.ie.driver", path + "\\src\\main\\java\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", path + "\\src\\main\\java\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot st = (TakesScreenshot) driver;
        File source = st.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;

    }
}
