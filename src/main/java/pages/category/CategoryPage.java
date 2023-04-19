package pages.category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class CategoryPage extends BasePage {
    @FindBy(css = ".h1")
    private WebElement category;
    @FindBy(css = "div.total-products")
    private WebElement totalProductsInfo;
    @FindBy(css = ".category-sub-menu a")
    private List<WebElement> listOfSubcategories;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }


    public String getCategoryName() {
        String categoryName = getTextOfElement(category);
        logger.info("Category name is: " + categoryName);
        return categoryName;
    }

    public int getSizeOfSubcategories() {
        return listOfSubcategories.size();
    }

    public WebElement getSubcategory(int j) {
        return listOfSubcategories.get(j);
    }

    public String getSubcategoryName(WebElement subcategory) {
        String subcategoryName = getTextOfElement(subcategory);
        logger.info("Subcategory name is: " + subcategoryName);
        return subcategoryName.toUpperCase();
    }

    public String getTotalProductsInfoText() {
        String productsInfo = getTextOfElement(totalProductsInfo);
        logger.info("Total Products Info is: " + productsInfo);
        return productsInfo;
    }

    public int getNumberOfTotalProductsInfo() {
        return getIntFromString(getTotalProductsInfoText());
    }

    public boolean isSubcategoryVisible() {
        return getSizeOfSubcategories() > 0;
    }

    public CategoryPage goToSubCategory(WebElement element) {
        element.click();
        return this;
    }
}
