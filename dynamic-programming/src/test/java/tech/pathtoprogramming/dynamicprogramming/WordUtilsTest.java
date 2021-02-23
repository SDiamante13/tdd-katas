package tech.pathtoprogramming.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordUtilsTest {


    @Test
    void canConstruct_shouldReturnTrue_givenAValidtargetWordAndListOfWords() {
        boolean result = WordUtils.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, null);

        assertThat(result).isTrue();
    }

    @Test
    void canConstruct_shouldReturnFalse_givenATargetWordsThatCannotBeConstructedGivenTheListOfWords() {
        boolean result = WordUtils.canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, null);

        assertThat(result).isFalse();
    }

    @Test
    void canConstruct_longString_needsMemoization() {
        boolean result = WordUtils.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, null);

        assertThat(result).isFalse();
    }

    @Test
    void countConstruct_purple() {
        int result = WordUtils.countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, null);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void countConstruct_enterpotentpot() {
        int result = WordUtils.countConstruct("enterpotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, null);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void countConstruct_eeef() {
        int result = WordUtils.countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, null);

        assertThat(result).isEqualTo(0);
    }
}