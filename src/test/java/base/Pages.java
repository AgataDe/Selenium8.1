package base;

import org.junit.jupiter.api.BeforeEach;
import pages.cart.CartPage;
import pages.cart.PopupPage;
import pages.category.CategoryPage;
import pages.checkout.CheckoutAddressPage;
import pages.checkout.CheckoutConfirmationPage;
import pages.checkout.CheckoutPaymentPage;
import pages.checkout.CheckoutShippingPage;
import pages.filter.FiltersSideMenuPage;
import pages.menu.TopMenuPage;
import pages.order.OrderDetailsPage;
import pages.order.OrderHistoryTablePage;
import pages.product.ProductDetailsPage;
import pages.product.ProductGridPage;
import pages.user.LoginPage;
import pages.user.UserAccountPage;

public class Pages extends BaseTest {
    public ProductGridPage productGridPage;
    public TopMenuPage topMenuPage;
    public CategoryPage categoryPage;
    public FiltersSideMenuPage filtersSideMenuPage;
    public ProductDetailsPage productDetailsPage;
    public PopupPage popupPage;
    public CartPage cartPage;
    public LoginPage loginPage;
    public UserAccountPage userAccountPage;
    public CheckoutAddressPage checkoutAddressPage;
    public CheckoutShippingPage checkoutShippingPage;
    public CheckoutPaymentPage checkoutPaymentPage;
    public CheckoutConfirmationPage checkoutConfirmationPage;
    public OrderHistoryTablePage orderHistoryTablePage;
    public OrderDetailsPage orderDetailsPage;


    @BeforeEach
    public void initPages() {
        productGridPage = new ProductGridPage(driver);
        topMenuPage = new TopMenuPage(driver);
        categoryPage = new CategoryPage(driver);
        filtersSideMenuPage = new FiltersSideMenuPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        popupPage = new PopupPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        userAccountPage = new UserAccountPage(driver);
        checkoutAddressPage = new CheckoutAddressPage(driver);
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutConfirmationPage = new CheckoutConfirmationPage(driver);
        orderHistoryTablePage = new OrderHistoryTablePage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
    }

}
