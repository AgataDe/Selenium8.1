package base;

import cofiguration.AppProperties;
import cofiguration.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    public WebDriver driver;
    private static AppProperties appProperties;
    private static DriverFactory driverFactory;
    protected static Logger logger = LoggerFactory.getLogger("BaseTest.class");


    @BeforeAll
    static void setupClass() {
        appProperties = AppProperties.getInstance();
        logger.info("AppProperties has been initialized");
        driverFactory = new DriverFactory();
    }

    @BeforeEach
    void setupDriver() {
        driver = driverFactory.getDriver();
        logger.info("DriverFactory has been initialized");
        driver.get(System.getProperty("appUrl"));
        logger.info("WebDriver setup");

    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Driver quit");
    }
}
