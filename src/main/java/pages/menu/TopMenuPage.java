package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.cart.CartPage;
import pages.category.CategoryPage;
import pages.home.HomePage;
import pages.user.LoginPage;
import pages.user.UserAccountPage;

import java.util.List;

public class TopMenuPage extends BasePage {
    @FindBy(css = "input.ui-autocomplete-input")
    private WebElement searchInput;
    @FindBy(css = ".logo.img-responsive")
    private WebElement myStoreLogo;
    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;
    @FindBy(css = "#ui-id-1")
    private WebElement dropDownList;
    @FindBy(css = "#ui-id-1 span[class='product']")
    private List<WebElement> listOfItems;
    @FindBy(css = "#top-menu>.category")
    private List<WebElement> listOfCategories;
    @FindBy(css = "span.cart-products-count")
    private WebElement cartQuantity;
    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement signInButton;
    @FindBy(css = "a.account")
    private WebElement myAccountButton;
    @FindBy(css = "#category-6")
    private WebElement accessoriesCategory;
    @FindBy(css = "#category-9")
    private WebElement artCategory;
    @FindBy(css = ".shopping-cart")
    private WebElement cartButton;


    public TopMenuPage(WebDriver driver) {
        super(driver);
    }


    public TopMenuPage fillSearchInput(String text) {
        logger.info("Product name: " + text + " has been entered into search field");
        sendKeys(searchInput, text);
        return this;
    }

    public HomePage goToHomePage() {
        waitToBeClickable(myStoreLogo);
        click(myStoreLogo);
        return new HomePage(driver);
    }

    public TopMenuPage checkSearch() {
        click(searchButton);
        return this;
    }

    public List<String> getProductNames() {
        waitToBeVisible(dropDownList);
        return getNames(listOfItems);
    }

    public int getSizeOfCategories() {
        return listOfCategories.size();
    }

    public WebElement getCategory(int i) {
        return listOfCategories.get(i);
    }

    public CategoryPage goToCategoryPage(WebElement category) {
        category.click();
        return new CategoryPage(driver);
    }

    public String getCategoryName(WebElement category) {
        String topMenuCategoryName = getTextOfElement(category);
        return topMenuCategoryName;
    }

    public CategoryPage openAccessoriesCategory() {
        click(accessoriesCategory);
        return new CategoryPage(driver);
    }

    public CategoryPage openArtCategory() {
        click(artCategory);
        return new CategoryPage(driver);
    }

    public int getCartQuantity() {
        waitToBeVisible(cartQuantity);
        return Integer.parseInt(getTextOfElement(cartQuantity)
                .replaceAll("\\(", "").replaceAll("\\)", ""));
    }

    public LoginPage clickOnSignInButton() {
        waitToBeClickable(signInButton);
        click(signInButton);
        return new LoginPage(driver);
    }

    public UserAccountPage goToMyAccount() {
        click(myAccountButton);
        return new UserAccountPage(driver);
    }

    public CartPage goToCart() {
        click(cartButton);
        return new CartPage(driver);
    }
}
