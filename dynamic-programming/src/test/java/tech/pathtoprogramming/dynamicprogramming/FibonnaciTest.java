package tech.pathtoprogramming.dynamicprogramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonnaciTest {

    @Test
    void fib_returns13_whenInputIs7() {
        Assertions.assertThat(Fibonnaci.fib(7, null)).isEqualTo(13L);
    }

    @Test
    void fib_returnsLargeNumber_whenInputIs50() {
        Assertions.assertThat(Fibonnaci.fib(50, null)).isEqualTo(12586269025L);
    }
}