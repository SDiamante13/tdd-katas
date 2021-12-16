package tech.pathtoprogramming.citysearch;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CitySearchTest {

    private final CitySearch citySearch = new CitySearch();

    @Test
    void searchReturnAnEmptyListWhenTheSearchTermIsLessThan2Characters() {
        List<String> actualCities = citySearch.search("a");

        assertThat(actualCities.isEmpty()).isTrue();
    }

    @Test
    void searchReturnsAllOfTheCitiesWhenTheSearchTermIsAnAsterisk() {
        List<String> actualCities = citySearch.search("*");

        Assertions.assertThat(actualCities).hasSize(16);
    }

    @Test
    void searchReturnAnListContainingTheMatchingCitiesWhenTheSearchTermAtLeast2Characters() {
        List<String> actualCities = citySearch.search("Va");

        assertThat(actualCities).contains("Vancouver", "Valencia");
    }

    @Test
    void searchReturnsMatchingCitiesRegardlessOfCase() {
        List<String> actualCities = citySearch.search("va");

        assertThat(actualCities).contains("Vancouver", "Valencia");
    }

    @Test
    void searchReturnsMatchingCitiesWhenSearchTermIsJustAPartOfTheCityName() {
        List<String> actualCities = citySearch.search("ape");

        assertThat(actualCities).contains("Budapest");
    }
}
