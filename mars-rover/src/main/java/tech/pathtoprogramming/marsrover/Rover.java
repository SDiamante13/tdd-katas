package tech.pathtoprogramming.marsrover;

public class Rover {

    Direction initialDirection = Direction.NORTH;

    public String execute(String command) {
        for (char c : command.toCharArray()) {
            if (c == 'R') {
                initialDirection = initialDirection.right();
            }
        }
        return "0:0:" + initialDirection.value();
    }
}
