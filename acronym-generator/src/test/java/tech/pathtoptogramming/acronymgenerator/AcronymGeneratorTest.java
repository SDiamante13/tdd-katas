package tech.pathtoptogramming.acronymgenerator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class AcronymGeneratorTest {
    @ParameterizedTest
    @CsvSource({
            "'',''",
            "Tom,T",
            "Tom Hanks,TH",
            "Jan Erich Mueller,JEM",
            "martin schmidt,MS",
            "Jan-Erich Schmidt,JES",
            "Paul Meyer-Schmidt,PMS",
            "Paul von Lahnstein,PvL",
            "Martin von Lahnstein-Meyer,MvLM"
    })
    void generate_returnsCorrectAcronym_whenNameIsGiven(String fullName, String expectedAcronym) {
        String actualAcronym = AcronymGenerator.generate(fullName);

        assertThat(actualAcronym).isEqualTo(expectedAcronym);
    }
}

class AcronymGenerator {

    private AcronymGenerator() {
    }

    public static String generate(String fullName) {
        if (fullName.isBlank()) {
            return "";
        }

        String[] names = fullName.split("[-\\s]");
        return Arrays.stream(names)
                .map(AcronymGenerator::toUpperCaseExceptForVon)
                .map(AcronymGenerator::firstLetter)
                .collect(Collectors.joining());
    }

    private static String firstLetter(String name) {
        return name.substring(0, 1);
    }

    private static String toUpperCaseExceptForVon(String s) {
        return s.equals("von") ? s : s.toUpperCase();
    }
}
