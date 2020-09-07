package tech.pathtoptogramming.acronymgenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AcronymGeneratorTest {

    @ParameterizedTest
    @CsvSource({
            "T,T",
            "Tom,T",
            "Tom Glavine,TG",
            ",''",
            "'',''",
            "elvis presley,EP",
            "Jan Erich Mueller,JEM",
            "Jan-Erich Schmidt,JES",
            "Paul Meyer-Schmidt,PMS",
            "Paul von Lahnstein,PvL",
            "Martin von Lahnstein-Meyer, MvLM"
    })
    void generate_returnsCorrectAcronym_whenNameIsGiven(String fullName, String expectedAcronym) {
        String actualAcronym = AcronymGenerator.generate(fullName);

        assertThat(actualAcronym).isEqualTo(expectedAcronym);
    }
}
