package categories;

import base.Pages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTest extends Pages {

    @Test
    @DisplayName("CategoriesTest")
    @Tag("Categories")
    public void shouldCheckCategories() {
        for (int i = 0; i < topMenuPage.getSizeOfCategories(); i++) {
            topMenuPage.goToCategoryPage(topMenuPage.getCategory(i));

            assertThat(categoryPage.getCategoryName()).isEqualTo(topMenuPage.getCategoryName(topMenuPage.getCategory(i)));
            assertThat(filtersSideMenuPage.isFiltersSideMenuIsDisplayed()).isTrue();
            assertThat(productGridPage.getAmountOfProducts()).isEqualTo(categoryPage.getNumberOfTotalProductsInfo());
        }
    }

    @Test
    @DisplayName("SubcategoriesTest")
    @Tag("Categories")
    public void shouldCheckSubcategories() {
        for (int i = 0; i < topMenuPage.getSizeOfCategories(); i++) {
            topMenuPage.goToCategoryPage(topMenuPage.getCategory(i));
            if (categoryPage.isSubcategoryVisible()) {
                for (int j = 0; j < categoryPage.getSizeOfSubcategories(); j++) {
                    String subcategoryName = categoryPage.getSubcategoryName(categoryPage.getSubcategory(j));
                    categoryPage.goToSubCategory(categoryPage.getSubcategory(j));
                    String subcategoryNameHeader = categoryPage.getCategoryName();

                    Assertions.assertThat(subcategoryNameHeader).isEqualTo(subcategoryName);
                    Assertions.assertThat(filtersSideMenuPage.isFiltersSideMenuIsDisplayed()).isTrue();
                    Assertions.assertThat(productGridPage.getAmountOfProducts()).isEqualTo(categoryPage.getNumberOfTotalProductsInfo());
                    driver.navigate().back();
                }
            }
        }
    }
}