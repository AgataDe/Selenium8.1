package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Random random;
    protected Actions actions;
    protected static Logger logger = LoggerFactory.getLogger("BasePage.class");

    public BasePage(WebDriver driver) {
        initDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, WebElement parent) {
        initDriver(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
    }

    public void initDriver(WebDriver driver) {
        this.driver = driver;
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("webElementTimeout"))));
        actions = new Actions(driver);
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(random.nextInt(elements.size()));
    }

    public Integer getRandomNumber(int min, int max) {
        return random.nextInt(min, max);
    }

    public String getTextOfElement(WebElement element) {
        return element.getText();
    }

    public void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void click(WebElement element) {
        waitToBeClickable(element);
        element.click();
    }

    public void clear(WebElement element) {
        waitToBeClickable(element);
        element.clear();
        logger.info("Element has been cleared");
    }

    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public List<String> getNames(List<WebElement> list) {
        List<String> namesList = new ArrayList<>();
        for (WebElement tempElement : list) {
            namesList.add(getTextOfElement(tempElement));
        }
        return namesList;
    }

    public int getIntFromString(String text) {
        return Integer.parseInt(text.replaceAll("\\D", ""));
    }


    public BigDecimal getPrice(WebElement element) {
        return new BigDecimal(element.getText().replace(System.getProperty("currency"), ""));
    }

    public String getStringPrice(WebElement element) {
        return element.getText().replace(System.getProperty("currency"), "");
    }

}
