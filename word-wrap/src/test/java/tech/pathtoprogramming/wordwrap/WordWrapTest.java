package tech.pathtoprogramming.wordwrap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordWrapTest {

    @Test
    void wrapReturnsAStringOfTheOriginalInputButWithLineBreaks() {
        String result = WordWrap.wrap("", 1);

        assertThat(result).isEmpty();
    }

    @Test
    void wrapReturnsSameStringWhenTheInputIsShorterThanColumnLength() {
        String result = WordWrap.wrap("dog", 2);

        assertThat(result).isEqualTo("dog");
    }

    @Test
    void wrapReturnsTheInputWithLineBreaksWhenTheInputIsGreaterOrEqualThanColumnLength() {
        String result = WordWrap.wrap("dog dog", 4);

        assertThat(result).isEqualTo("dog\ndog");
    }

    @Test
    void wrapReturnsTheInputThreeWords() {
        String result = WordWrap.wrap("dog dog", 7);

        assertThat(result).isEqualTo("dog dog");
    }
}
