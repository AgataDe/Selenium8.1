package filters;

import base.Pages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FiltersTest extends Pages {

    @Test
    @DisplayName("FiltersTest")
    @Tag("Filters")
    public void shouldDisplayProductsUsingFilters() {
        double valueMin = Double.parseDouble(System.getProperty("lowPrice"));
        double valueMax = Double.parseDouble(System.getProperty("highPrice"));
        topMenuPage.openAccessoriesCategory();
        int quantityOfProducts = productGridPage.getAmountOfProducts();

        filtersSideMenuPage.setLowPrice(valueMin)
                .setHighPrice(valueMax);

        int quantityOfProductsAfterFiltered = productGridPage.getAmountOfProducts();
        int quantityOfProductsBetweenPriceRange = productGridPage.getAmountAfterFiltered(valueMin, valueMax);

        Assertions.assertThat(quantityOfProductsAfterFiltered).isEqualTo(quantityOfProductsBetweenPriceRange);

        filtersSideMenuPage.clearAll();
        int quantityAfterClearFilter = productGridPage.getAmountOfProducts();

        Assertions.assertThat(quantityOfProducts).isEqualTo(quantityAfterClearFilter);
    }
}
