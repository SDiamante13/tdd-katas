package tech.pathtoprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class APlayerShould {

    @Test
    void startTheGameWithDefaults() {
        Player player = new Player();

        assertThat(player.location()).isZero();
        assertThat(player.money()).isEqualTo(1500);
    }

    @Test
    void buyProperties() {
        Player player = new Player();
        Property property = new Property("Baltic Avenue", 60);

        player.buy(property);

        assertThat(player.properties()).contains(property);
        assertThat(player.money()).isEqualTo(1500 - 60);
    }
}