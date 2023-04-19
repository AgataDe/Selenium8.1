package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class ProductGridPage extends BasePage {
    @FindBy(css = ".product-miniature")
    private List<WebElement> productMiniatures;
    @FindBy(css = ".product-title a")
    private List<WebElement> listOfProductNames;
    @FindBy(css = "div[class='product-description'] a")
    private WebElement productName;


    public ProductGridPage(WebDriver driver) {
        super(driver);
    }


    public List<ProductMiniaturePage> getProducts() {
        return productMiniatures
                .stream()
                .map(productMiniature -> new ProductMiniaturePage(driver, productMiniature))
                .collect(Collectors.toList());
    }

    public int getAmountAfterFiltered(double valueMin, double valueMax) {
        return (int) getProducts()
                .stream()
                .filter(p -> p.getPriceInD() >= valueMin && p.getPriceInD() <= valueMax)
                .count();
    }

    public String getProductName() {
        return getTextOfElement(productName);
    }

    public int getAmountOfProducts() {
        return getProducts().size();
    }

    public ProductDetailsPage openProductWithName(String someName) {
        for (ProductMiniaturePage productMiniaturePage : getProducts()) {
            if (productMiniaturePage.getProductName().equals(someName)) {
                productMiniaturePage.open();
                break;
            }
        }
        return new ProductDetailsPage(driver);
    }

    public String getRandomProductName() {
        logger.info("The name was chosen randomly");
        return getTextOfElement(getRandomElement(listOfProductNames));
    }

    public ProductDetailsPage openRandomProduct() {
        new ProductMiniaturePage(driver, getRandomElement(productMiniatures)).open();
        return new ProductDetailsPage(driver);
    }

}
