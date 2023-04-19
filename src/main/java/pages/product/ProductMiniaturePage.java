package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.math.BigDecimal;

public class ProductMiniaturePage extends BasePage {
    @FindBy(css = ".product-title")
    private WebElement productName;
    @FindBy(css = ".price")
    private WebElement price;


    public ProductMiniaturePage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }


    public String getProductName() {
        return getTextOfElement(productName);
    }

    public BigDecimal getPrice() {
        return getPrice(price);
    }

    public double getPriceInD() {
        return Double.parseDouble(getTextOfElement(price).replace((System.getProperty("currency")), ""));
    }

    public ProductMiniaturePage open() {
        click(productName);
        return this;
    }
}
