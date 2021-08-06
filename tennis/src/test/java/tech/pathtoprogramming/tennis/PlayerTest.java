package tech.pathtoprogramming.tennis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void initializedPlayerHasScoreOfZero() {
        int expected = 0;

        Player player = new Player();

        Assertions.assertThat(player.getScore()).isEqualTo(expected);
    }

    @Test
    void winPoint_iteratesPlayersScore() {
        Player player = new Player();

        player.winPoint();

        Assertions.assertThat(player.getScore()).isEqualTo(1);
    }
}