package pages.filter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class FiltersSideMenuPage extends BasePage {
    @FindBy(css = "div#search_filters")
    private WebElement filterMenu;
    @FindBy(css = ".faceted-slider")
    private WebElement slider;
    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private WebElement leftSlider;
    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private WebElement rightSlider;
    @FindBy(css = "li>p")
    private WebElement currentPriceFilter;
    @FindBy(css = ".spinner")
    private WebElement spinner;
    @FindBy(css = "#_desktop_search_filters_clear_all>button")
    private WebElement clearFilterButton;


    public FiltersSideMenuPage(WebDriver driver) {
        super(driver);
    }


    public boolean isFiltersSideMenuIsDisplayed() {
        waitToBeVisible(filterMenu);
        return true;
    }

    private String[] getPriceRange() {
        return getStringPrice(currentPriceFilter).split("-");
    }

    private Double getMinPrice() {
        return Double.parseDouble(getPriceRange()[0]);
    }

    private Double getMaxPrice() {
        return Double.parseDouble(getPriceRange()[1]);
    }

    public void clearAll() {
        clearFilterButton.click();
        waitUntilDisappear(clearFilterButton);
        logger.info("Filter has been cleared");
    }

    public FiltersSideMenuPage setLowPrice(double price) {
        logger.info("Low price has been set: " + price);
        return moveSlider(price, getMinPrice(), leftSlider);
    }

    public FiltersSideMenuPage setHighPrice(double price) {
        logger.info("High price has been set: " + price);
        return moveSlider(price, getMaxPrice(), rightSlider);
    }

    private FiltersSideMenuPage moveSlider(double price, double currentPrice, WebElement sliderHandle) {
        if (currentPrice == price) {
            return this;
        }
        double minPrice = Double.parseDouble(slider.getAttribute("data-slider-min"));
        double maxPrice = Double.parseDouble(slider.getAttribute("data-slider-max"));
        int sliderWidth = slider.getSize().width;

        if (price < minPrice || price > maxPrice) {
            return this;
        }

        int direction = getDirection(price, currentPrice);

        actions.clickAndHold(sliderHandle).perform();
        while (getMaxPrice() != price && getMinPrice() != price) {
            actions.moveByOffset((int) (direction * (sliderWidth / (maxPrice - minPrice))), 0).perform();
        }
        actions.release().perform();
        waitUntilDisappear(spinner);
        return this;
    }

    private int getDirection(double price, double currentPrice) {
        double difference = price - currentPrice;
        if (difference > 0) {
            return 1;
        }
        if (difference < 0) {
            return -1;
        }
        return 0;
    }
}
