package tech.pathtoprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpacesShould {

    // TODO: Write an approval test for this
    @Test
    void haveFortyTotal() {
        Spaces spaces = new Spaces();

        assertThat(spaces.at(39).name()).isEqualTo("Boardwalk");
        assertThat(spaces.at(0).name()).isEqualTo("GO");
    }
}