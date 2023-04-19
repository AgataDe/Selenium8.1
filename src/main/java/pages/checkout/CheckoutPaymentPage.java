package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CheckoutPaymentPage extends BasePage {
    @FindBy(css = "input#payment-option-1")
    private WebElement payByCheckInput;
    @FindBy(css = ".custom-checkbox .ps-shown-by-js")
    private WebElement termsOfServiceCheckbox;
    @FindBy(css = "button.btn.btn-primary.center-block")
    private WebElement placeOrderButton;


    public CheckoutPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void selectPaymentOptions() {
        payByCheckInput.click();
        logger.info("Pay by check option has been selected");
        termsOfServiceCheckbox.click();
        logger.info("Terms of services option has been selected");
        placeOrderButton.click();
    }
}
