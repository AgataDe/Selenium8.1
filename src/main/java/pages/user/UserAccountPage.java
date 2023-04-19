package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class UserAccountPage extends BasePage {

    @FindBy(css = "#history-link>span")
    private WebElement orderHistoryAndDetailsButton;


    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    public void goToOrderHistoryAndDetails() {
        click(orderHistoryAndDetailsButton);
    }
}
