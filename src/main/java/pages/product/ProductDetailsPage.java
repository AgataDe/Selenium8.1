package pages.product;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.cart.PopupPage;

import java.math.BigDecimal;

public class ProductDetailsPage extends BasePage {
    @FindBy(css = "button.add-to-cart")
    private WebElement addToCartButton;
    @FindBy(css = ".current-price>span")
    private WebElement price;
    @FindBy(css = ".h1")
    private WebElement product;
    @FindBy(css = "input#quantity_wanted")
    private WebElement quantityInput;


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }


    public String getName() {
        return getTextOfElement(product);
    }

    public ProductDetailsPage setQuantityToChosenNumber(String chosenQuantity) {
        clear(quantityInput);
        sendKeys(quantityInput, chosenQuantity);
        return this;
    }

    public PopupPage addToCart() {
        click(addToCartButton);
        waitToBeVisible(addToCartButton);
        return new PopupPage(driver);
    }

    public BigDecimal getProductPrice() {
        return getPrice(price);
    }


    public ProductDetailsPage setRandomQuantity(int minRange, int maxRange) {
        String range = getRandomRange(minRange, maxRange);
        clear(quantityInput);
        sendKeys(quantityInput, range);
        logger.info("Quantity is: " + range);
        return this;
    }

    public int getQuantity() {
        int productQuantity = Integer.parseInt((quantityInput.getAttribute("value")));
        logger.info("Product quantity: " + productQuantity);
        return productQuantity;
    }

    private String getRandomRange(int minRange, int maxRange) {
        return String.valueOf(getRandomNumber(minRange, maxRange));
    }

    public BigDecimal getTotalPrice() {
        return getProductPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }

    public Product getProductDetails() {
        return new Product(getName(), getProductPrice(), getQuantity(), getTotalPrice());
    }
}
