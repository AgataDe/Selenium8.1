package cofiguration;

import cofiguration.browser.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
    private Browsers browsers;
    private WebDriver driver;
    public Logger logger = LoggerFactory.getLogger("DriverFactory.class");

    public WebDriver getDriver() {
        this.browsers = Browsers.valueOf(System.getProperty("browserName").toUpperCase());
        switch (browsers) {
            case CHROME -> {
                getChromeDriver();
            }
            case FIREFOX -> {
                getFirefoxDriver();
            }
            case IE -> {
                getIEDriver();
            }
            case EDGE -> {
                getEdgeDriver();
            }
        }
        return this.driver;
    }

    private void getChromeDriver() {
        ChromeOptions optionsChrome = new ChromeOptions().addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(optionsChrome);
    }

    private void getFirefoxDriver() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        optionsFirefox.addArguments("start-maximized");
        driver = new FirefoxDriver(optionsFirefox);
    }

    private void getIEDriver() {
        InternetExplorerOptions optionsExplorer = new InternetExplorerOptions();
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver(optionsExplorer);
    }

    private void getEdgeDriver() {
        EdgeOptions optionsEdge = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(optionsEdge);
    }

}
