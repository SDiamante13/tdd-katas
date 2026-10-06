package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void getStateAsString() {
        assertThat(new Cell(State.DEAD, 0, 0).getStateAsString()).isEqualTo("0");
        assertThat(new Cell(State.ALIVE, 0, 0).getStateAsString()).isEqualTo("1");
    }
}