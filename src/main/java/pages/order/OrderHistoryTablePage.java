package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryTablePage extends BasePage {
    @FindBy(css = "tbody>tr")
    private List<WebElement> listOfOrders;
    @FindBy(css = "a[data-link-action='view-order-details']")
    private WebElement detailsButton;


    public OrderHistoryTablePage(WebDriver driver) {
        super(driver);
    }


    public List<OrderHistoryRowPage> getAllOrders() {
        List<OrderHistoryRowPage> allOrders = new ArrayList<>();
        for (WebElement order : listOfOrders) {
            allOrders.add(new OrderHistoryRowPage(driver, order));
        }
        return allOrders;
    }

    public OrderDetailsPage openDetails() {
        waitToBeClickable(detailsButton);
        click(detailsButton);
        return new OrderDetailsPage(driver);
    }

}

