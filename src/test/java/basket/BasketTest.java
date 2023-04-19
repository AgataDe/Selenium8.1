package basket;

import base.Pages;
import models.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketTest extends Pages {

    @Test
    @DisplayName("BasketTest")
    @Tag("Basket")
    public void shouldAddProductsToShoppingCart() {
        topMenuPage.goToHomePage();
        String posterName = System.getProperty("poster");
        String posterQuantity = System.getProperty("quantity");
        String shippingPrice = System.getProperty("shipping");
        int posterQuantityInt = Integer.parseInt(posterQuantity);
        int shippingPriceInt = Integer.parseInt(shippingPrice);

        topMenuPage.openArtCategory();
        productGridPage.openProductWithName(posterName);
        productDetailsPage.setQuantityToChosenNumber(posterQuantity)
                .addToCart()
                .waitForVisibilityOfPopUp();
        BigDecimal correctPrice = productDetailsPage.getProductPrice();

        Assertions.assertThat(popupPage.getProductName()).isEqualTo(productDetailsPage.getName());
        Assertions.assertThat(popupPage.getProductPrice()).isEqualTo(correctPrice);
        Assertions.assertThat(popupPage.getProductQuantity()).isEqualTo(posterQuantityInt);
        Assertions.assertThat(popupPage.getItemsQuantityFromCart()).isEqualTo("There are " + posterQuantity +
                " items in your cart.");

        BigDecimal priceOfAllQuantity = productDetailsPage.getProductPrice().multiply(BigDecimal.valueOf
                (posterQuantityInt));
        BigDecimal total = priceOfAllQuantity.add(BigDecimal.valueOf(shippingPriceInt));

        Assertions.assertThat(popupPage.getTotalProductsValue()).isEqualTo(total);

        popupPage.clickContinueShopping();

        Assertions.assertThat(topMenuPage.getCartQuantity()).isEqualTo(posterQuantityInt);
    }

    @Test
    @DisplayName("Basket Generic Test")
    @Tag("Basket")
    public void shouldAddRandomProducts() {
        int basketIteration = Integer.parseInt(System.getProperty("basketIteration"));
        int minRange = Integer.parseInt(System.getProperty("minRange"));
        int maxRange = Integer.parseInt(System.getProperty("maxRange"));
        Order expectedOrder = new Order();

        for (int i = 0; i < basketIteration; i++) {
            topMenuPage.goToHomePage();
            productGridPage.openRandomProduct();
            productDetailsPage.setRandomQuantity(minRange, maxRange);
            expectedOrder.addProduct(productDetailsPage.getProductDetails());
            productDetailsPage.addToCart();
            popupPage.waitForVisibilityOfPopUp()
                    .clickContinueShopping();
            driver.navigate().back();
        }
        driver.get(System.getProperty("cartUrl"));
        Order actualOrder = cartPage.toOrder();
        Assertions.assertThat(actualOrder).usingRecursiveComparison().isEqualTo(expectedOrder);
    }

    @Test
    @DisplayName("Basket - remove products test")
    @Tag("Basket")
    public void shouldAddAndRemoveProducts() {
        int numberOfProducts = Integer.parseInt(System.getProperty("numberOfProducts"));
        String value = System.getProperty("value");
        BigDecimal shippingPrice = BigDecimal.valueOf(Integer.parseInt(System.getProperty("shipping")));
        Order expectedOrder = new Order();

        for (int i = 0; i < numberOfProducts; i++) {
            topMenuPage.goToHomePage();
            productGridPage.openRandomProduct();
            productDetailsPage.setQuantityToChosenNumber(value);
            expectedOrder.addProduct(productDetailsPage.getProductDetails());
            productDetailsPage.addToCart();
            popupPage.waitForVisibilityOfPopUp()
                    .clickContinueShopping();
        }
        topMenuPage.goToCart();
        Assertions.assertThat(cartPage.getTotalPrice()).isEqualTo(expectedOrder.getTotalOrderPriceWithShipping());
        cartPage.removeProductFromCart(1, expectedOrder);
        Assertions.assertThat(cartPage.getTotalPrice()).isEqualTo(expectedOrder.getTotalOrderPrice().add(shippingPrice));
        cartPage.removeProductFromCart(1, expectedOrder);
        Assertions.assertThat(cartPage.getEmptyCartLabel()).isEqualTo("There are no more items in your cart");
    }
}
