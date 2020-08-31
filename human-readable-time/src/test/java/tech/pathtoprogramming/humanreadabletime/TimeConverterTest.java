package tech.pathtoprogramming.humanreadabletime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TimeConverterTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0,00:00:00",
            "5,00:00:05",
            "60,00:01:00",
            "75,00:01:15",
            "5400,01:30:00",
            "86399,23:59:59",
            "359999,99:59:59"
    })
    void beautifyTime_returnsHumanReadableTime(int input, String expectedOutput) {
        String actualTime = TimeConverter.beautifyTime(input);

        assertThat(actualTime).isEqualTo(expectedOutput);
    }

    @Test
    void beautifyTime_throwsIllegalArgumentException_whenInputIsAbove359999() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                TimeConverter.beautifyTime(360000));
    }

    @Test
    void beautifyTime_throwsIllegalArgumentException_whenInputIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                TimeConverter.beautifyTime(-1));
    }
}
