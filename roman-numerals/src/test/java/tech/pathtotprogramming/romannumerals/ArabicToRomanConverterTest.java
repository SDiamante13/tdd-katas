package tech.pathtotprogramming.romannumerals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArabicToRomanConverterTest {
    @Test
    void convert1ToI() {
        var arabicToRomanConverter = new ArabicToRomanConverter();
        String roman = arabicToRomanConverter.convert(1);
        Assertions.assertThat(roman).isEqualTo("I");
    }

    @Test
    void convert2ToII() {
        var arabicToRomanConverter = new ArabicToRomanConverter();
        String roman = arabicToRomanConverter.convert(2);
        Assertions.assertThat(roman).isEqualTo("II");
    }

    @Test
    void convert3ToIII() {
        var arabicToRomanConverter = new ArabicToRomanConverter();
        String roman = arabicToRomanConverter.convert(3);
        Assertions.assertThat(roman).isEqualTo("III");
    }
}
