package tech.pathtoprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class APlayerShould {

    @Test
    void startTheGameOnTheGoSpace() {
        Player player = new Player();

        assertThat(player.location()).isEqualTo(0);
    }
}