package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CheckoutAddressPage extends BasePage {
    @FindBy(css = "p:nth-of-type(4)")
    private WebElement newInvoiceAddressForm;
    @FindBy(css = "#checkout-addresses-step>div>div>form>p:nth-child(8)>a")
    private WebElement addNewInvoiceButton;
    @FindBy(css = "input[name='address1']")
    private WebElement addressInput;
    @FindBy(css = "input[name='postcode']")
    private WebElement zipCodeInput;
    @FindBy(css = "input[name='city']")
    private WebElement cityInput;
    @FindBy(css = "button[name='confirm-addresses']")
    private WebElement continueButton;
    @FindBy(css = "#checkout-addresses-step")
    private WebElement addressesSectionTab;
    @FindBy(css = "#delivery-addresses .selected .address")
    private WebElement addedDeliveryAddress;
    @FindBy(css = "#invoice-addresses .selected .address")
    private WebElement addedInvoiceAddress;


    public CheckoutAddressPage(WebDriver driver) {
        super(driver);
    }


    public CheckoutAddressPage openInvoiceForm() {
        click(newInvoiceAddressForm);
        logger.info("New invoice address form has been opened");
        return this;
    }

    public CheckoutAddressPage fillNewInvoiceAddressForm() {
        click(addNewInvoiceButton);
        addressInput.sendKeys(System.getProperty("address"));
        zipCodeInput.sendKeys(System.getProperty("zipCode"));
        cityInput.sendKeys(System.getProperty("City"));
        clickContinueButton();
        logger.info("New invoice address form has been filled");
        return this;
    }

    public CheckoutShippingPage clickContinueButton() {
        click(continueButton);
        logger.info("Continue button has been clicked");
        return new CheckoutShippingPage(driver);
    }

    public CheckoutAddressPage openAddressesSection() {
        click(addressesSectionTab);
        logger.info("Addresses section has been opened");
        return this;
    }

    public String getAddedDeliveryAddress() {
        waitToBeVisible(addedDeliveryAddress);
        return addedDeliveryAddress.getText();
    }

    public String getAddedInvoiceAddress() {
        waitToBeVisible(addedInvoiceAddress);
        return getTextOfElement(addedInvoiceAddress);

    }

}
