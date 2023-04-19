package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderDetailsPage extends BasePage {
    @FindBy(css = "#order-history td")
    private WebElement date;
    @FindBy(css = ".line-total>td:nth-child(2)")
    private WebElement totalPrice;
    @FindBy(css = "tbody .label")
    private WebElement paymentLabel;
    @FindBy(css = "#delivery-address address")
    private WebElement deliveryAddress;
    @FindBy(css = "#invoice-address address")
    private WebElement invoiceAddress;


    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }


    public String getDate() {
        logger.info("Order date is: " + getTextOfElement(date));
        return getTextOfElement(date);
    }

    public String getTotalPrice() {
        logger.info("Order total price is: " + getTextOfElement(totalPrice));
        return getTextOfElement(totalPrice);
    }

    public String getPaymentStatus() {
        return getTextOfElement(paymentLabel);
    }

    public String getDeliveryAddress() {
        logger.info("Delivery address is : " + getTextOfElement(deliveryAddress));
        return getTextOfElement(deliveryAddress);
    }

    public String getInvoiceAddress() {
        logger.info("Invoice address is: " + getTextOfElement(invoiceAddress));
        return getTextOfElement(invoiceAddress);
    }
}
