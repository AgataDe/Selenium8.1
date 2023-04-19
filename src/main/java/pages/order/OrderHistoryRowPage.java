package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderHistoryRowPage extends BasePage {

    @FindBy(css = "th")
    private WebElement orderReference;
    @FindBy(css = ".order-actions > a:nth-child(1)")
    private WebElement details;


    public OrderHistoryRowPage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    public WebElement getOrderReference() {
        return orderReference;
    }

    public WebElement getDetails() {
        return details;
    }
}
