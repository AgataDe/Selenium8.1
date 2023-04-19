package searchTests;

import base.Pages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SearchTest extends Pages {

    @Test
    @DisplayName("SearchTest")
    @Tag("Search")
    public void shouldSearchRandomProduct() {
        String randomProduct = productGridPage.getRandomProductName();
        topMenuPage.fillSearchInput(randomProduct)
                .checkSearch();

        Assertions.assertThat(productGridPage.getProductName()).isEqualTo(randomProduct);
    }

    @Test
    @DisplayName("SearchDropdownTest")
    @Tag("Search")
    public void shouldSearchFromDropdown() {
        String typeInput = System.getProperty("typeText");
        topMenuPage.fillSearchInput(typeInput);

        for (String productName : topMenuPage.getProductNames()) {
            Assertions.assertThat(productName).contains(typeInput);
        }
    }
}
