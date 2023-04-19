package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CheckoutConfirmationPage extends BasePage {
    @FindBy(css = ".total-value td:last-of-type")
    private WebElement totalPrice;


    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }


    public String getTotalPrice() {
        logger.info("Confirmation total price: " + getTextOfElement(totalPrice));
        return getTextOfElement(totalPrice);
    }
}
