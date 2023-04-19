package checkout;

import base.Pages;
import handlers.UserFactory;
import models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutTest extends Pages {

    @Test
    @DisplayName("CheckoutTest")
    @Tag("Checkout")
    public void shouldCheckData() {
        User registeredUser = new UserFactory().getAlreadyRegisteredUser();
        String posterName = System.getProperty("poster");
        String posterQuantity = System.getProperty("quantityCheckout");
        String statusAwaiting = System.getProperty("status");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");
        Date date = new Date();
        String today = dateFormat.format(date);

        topMenuPage.clickOnSignInButton();
        loginPage.logIn(registeredUser);
        topMenuPage.openArtCategory();
        productGridPage.openProductWithName(posterName)
                .setQuantityToChosenNumber(posterQuantity)
                .addToCart();
        popupPage.clickProceedToCheckout()
                .clickProceedToCheckout();
        checkoutAddressPage.openInvoiceForm()
                .fillNewInvoiceAddressForm()
                .openAddressesSection();
        String addedDeliveryAddress = checkoutAddressPage.getAddedDeliveryAddress();
        String addedInvoiceAddress = checkoutAddressPage.getAddedInvoiceAddress();
        checkoutAddressPage.clickContinueButton()
                .selectShippingMethod();
        checkoutPaymentPage.selectPaymentOptions();
        String confirmationTotalPrice = checkoutConfirmationPage.getTotalPrice();
        topMenuPage.goToMyAccount();
        userAccountPage.goToOrderHistoryAndDetails();
        orderHistoryTablePage.getAllOrders();
        orderHistoryTablePage.openDetails();

        Assertions.assertThat(orderDetailsPage.getDate()).isEqualTo(today);
        Assertions.assertThat(orderDetailsPage.getTotalPrice()).isEqualTo(confirmationTotalPrice);
        Assertions.assertThat(orderDetailsPage.getPaymentStatus()).isEqualTo(statusAwaiting);
        Assertions.assertThat(orderDetailsPage.getDeliveryAddress()).isEqualTo(addedDeliveryAddress);
        Assertions.assertThat(orderDetailsPage.getInvoiceAddress()).isEqualTo(addedInvoiceAddress);
        Assertions.assertThat(orderDetailsPage.getInvoiceAddress())
                .contains(System.getProperty("firstName")).contains(System.getProperty("lastName"))
                .contains(System.getProperty("address")).contains(System.getProperty("zipCode"))
                .contains(System.getProperty("City")).contains(System.getProperty("country"));
    }
}
