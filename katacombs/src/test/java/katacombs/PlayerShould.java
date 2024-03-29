package katacombs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerShould {

    @Test
    void goNorth() {
        Player player = new Player(new Coordinates(0, 0));

        player.go(Direction.N);

        assertThat(player.currentCoordinates()).isEqualTo(new Coordinates(0, 1));
    }

    @Test
    void goSouth() {
        Player player = new Player(new Coordinates(0, 0));

        player.go(Direction.S);

        assertThat(player.currentCoordinates()).isEqualTo(new Coordinates(0, -1));
    }

    @Test
    void goWest() {
        Player player = new Player(new Coordinates(0, 0));

        player.go(Direction.W);

        assertThat(player.currentCoordinates()).isEqualTo(new Coordinates(-1, 0));
    }

    @Test
    void goEast() {
        Player player = new Player(new Coordinates(0, 0));

        player.go(Direction.E);

        assertThat(player.currentCoordinates()).isEqualTo(new Coordinates(1, 0));
    }

    @Test
    void lookNorth() {
        Player player = new Player(new Coordinates(0, 0));

        Coordinates coordinates = player.look(Direction.N);

        assertThat(coordinates).isEqualTo(new Coordinates(0, 1));
    }

    @Test
    void lookEast() {
        Player player = new Player(new Coordinates(0, 0));

        Coordinates coordinates = player.look(Direction.E);

        assertThat(coordinates).isEqualTo(new Coordinates(1, 0));
    }

    @Test
    void lookSouth() {
        Player player = new Player(new Coordinates(0, 0));

        Coordinates coordinates = player.look(Direction.S);

        assertThat(coordinates).isEqualTo(new Coordinates(0, -1));
    }

    @Test
    void lookWest() {
        Player player = new Player(new Coordinates(0, 0));

        Coordinates coordinates = player.look(Direction.W);

        assertThat(coordinates).isEqualTo(new Coordinates(-1, 0));
    }
}
