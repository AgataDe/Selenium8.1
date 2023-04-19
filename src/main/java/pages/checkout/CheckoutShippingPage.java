package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CheckoutShippingPage extends BasePage {
    @FindBy(css = "#delivery_option_2")
    private WebElement myCarrierOption;
    @FindBy(css = "button[name='confirmDeliveryOption']")
    private WebElement continueButton;


    public CheckoutShippingPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutShippingPage selectShippingMethod() {
        waitToBeClickable(continueButton);
        myCarrierOption.click();
        logger.info("Shipping method has been selected");
        click(continueButton);
        logger.info("Continue button has been clicked");
        return this;
    }
}
