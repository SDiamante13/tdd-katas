package tech.pathtoprogramming.marsrover;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoversTest {

    @ParameterizedTest
    @CsvSource({
            "R,0:0:E",
            "RR,0:0:S",
            "RRR,0:0:W",
            "RRRR,0:0:N"
    })
    void turnsRight(String command, String expectedPosition) {
        Rover rover = new Rover();

        String actualPosition = rover.execute(command);

        Assertions.assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}

