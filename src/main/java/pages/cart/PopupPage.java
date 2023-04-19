package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.product.ProductDetailsPage;

import java.math.BigDecimal;

public class PopupPage extends BasePage {
    @FindBy(css = "#myModalLabel")
    private WebElement popupLabel;
    @FindBy(css = "p.product-price")
    private WebElement productPrice;
    @FindBy(css = ".product-name")
    private WebElement productName;
    @FindBy(css = "span.product-quantity strong")
    private WebElement productQuantity;
    @FindBy(css = ".product-total>.value")
    private WebElement totalProductsValue;
    @FindBy(css = ".btn.btn-secondary")
    private WebElement continueShoppingButton;
    @FindBy(css = "p.cart-products-count")
    private WebElement cartProductsCount;
    @FindBy(css = "a.btn-primary")
    private WebElement proceedToCheckoutButton;


    public PopupPage(WebDriver driver) {
        super(driver);
    }


    public PopupPage waitForVisibilityOfPopUp() {
        waitToBeVisible(popupLabel);
        return new PopupPage(driver);
    }

    public String getProductName() {
        waitToBeVisible(productName);
        return getTextOfElement(productName);
    }

    public BigDecimal getProductPrice() {
        return getPrice(productPrice);
    }

    public int getProductQuantity() {
        return Integer.parseInt(getTextOfElement(productQuantity));
    }

    public BigDecimal getTotalProductsValue() {
        return getPrice(totalProductsValue);
    }

    public String getItemsQuantityFromCart() {
        return getTextOfElement(cartProductsCount);
    }

    public ProductDetailsPage clickContinueShopping() {
        waitToBeClickable(continueShoppingButton);
        click(continueShoppingButton);
        logger.info("Continue shopping button has been clicked");
        return new ProductDetailsPage(driver);
    }

    public CartPage clickProceedToCheckout() {
        waitToBeClickable(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
        logger.info("Proceed to checkout button has been clicked");
        return new CartPage(driver);
    }
}
