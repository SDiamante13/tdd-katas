package tech.pathtoprogramming.citysearch;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CitySearch {

    private final List<String> cities;

    public CitySearch() {
        this.cities = Arrays.asList(
                "Paris",
                "Budapest",
                "Skopje",
                "Rotterdam",
                "Valencia",
                "Vancouver",
                "Amsterdam",
                "Vienna",
                "Sydney",
                "New York City",
                "London",
                "Bangkok",
                "Hong Kong",
                "Dubai",
                "Rome",
                "Istanbul"
        );
    }

    public List<String> search(String searchTerm) {
        if (searchTerm.equals("*")) {
            return cities;
        }

        if (searchTerm.length() > 1) {
            return cities
                    .stream()
                    .filter(city -> StringUtils.containsIgnoreCase(city, searchTerm))
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
