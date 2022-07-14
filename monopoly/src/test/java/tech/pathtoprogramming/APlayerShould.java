package tech.pathtoprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class APlayerShould {

    Player player = new Player();


    @Test
    void startTheGameWithDefaults() {

        assertThat(player.location()).isZero();
        assertThat(player.money()).isEqualTo(1500);
    }

    @Test
    void buyProperties() {
        Property property = new Property("Baltic Avenue", 60);

        player.buy(property);

        assertThat(player.properties()).contains(property);
        assertThat(player.money()).isEqualTo(1500 - 60);
    }

    @Test
    void moveFromItsCurrentLocationToAnotherLocation() {
        Player player = new Player();

        player.moveSpaces(2);

        assertThat(player.location()).isEqualTo(2);
    }

    @Test
    void goAroundTheEntireBoard() {
        Player player = new Player();
        player.moveTo(39);

        player.moveSpaces(1);

        assertThat(player.location()).isZero();
    }
}