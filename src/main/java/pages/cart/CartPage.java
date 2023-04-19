package pages.cart;

import models.Order;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;
import pages.checkout.CheckoutAddressPage;

import java.math.BigDecimal;
import java.util.List;

public class CartPage extends BasePage {
    @FindBy(css = ".cart-item")
    private List<WebElement> productsInCart;
    @FindBy(css = ".cart-total>.value")
    private WebElement totalPrice;
    @FindBy(css = "a.btn.btn-primary")
    private WebElement proceedToCheckoutButton;
    @FindBy(css = ".remove-from-cart")
    private List<WebElement> removeProductButton;
    @FindBy(css = "span.no-items")
    private WebElement emptyCartLabel;


    public CartPage(WebDriver driver) {
        super(driver);
    }


    public Order toOrder() {
        Order order = new Order();
        for (WebElement cartItem : productsInCart) {
            order.addProduct(new Product(
                    cartItem.findElement(By.cssSelector(".product-line-info>a")).getText(),
                    getPrice(cartItem.findElement(By.cssSelector(".current-price"))),
                    Integer.parseInt(cartItem.findElement(By.cssSelector(".js-cart-line-product-quantity")).getAttribute("value")),
                    getPrice(cartItem.findElement(By.cssSelector("span.product-price")))
            ));
        }
        return order;
    }

    public List<WebElement> getProductsInCart() {
        return productsInCart;
    }


    public int quantityOfProductsToBeRemoved() {
        return removeProductButton.size();
    }

    public CartPage removeProductFromCart(int index, Order order) {
        waitToBeClickable(removeProductButton.get(0));
        click(removeProductButton.get(index - 1));
        order.removeProduct(order.getProducts().get(0));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".remove-from-cart"), quantityOfProductsToBeRemoved() - 1));
        return this;
    }

    public String getEmptyCartLabel() {
        waitToBeVisible(emptyCartLabel);
        return getTextOfElement(emptyCartLabel);
    }

    public BigDecimal getTotalPrice() {
        return getPrice(totalPrice);
    }

    public CheckoutAddressPage clickProceedToCheckout() {
        waitToBeClickable(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
        logger.info("Proceed to checkout button on CartPage has been clicked");
        return new CheckoutAddressPage(driver);
    }
}
