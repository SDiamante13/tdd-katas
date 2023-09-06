package tech.pathtoprogramming.marsrover;

enum Direction {
    NORTH("N", "E"),
    EAST("E", "S"),
    SOUTH("S", "W"),
    WEST("W", "N");

    private String value;
    private String right;

    Direction(String value, String right) {
        this.value = value;
        this.right = right;
    }

    public Direction right() {
        for (Direction direction :
                Direction.values()) {
            if (direction.value.equals(this.right)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Unknown direction");
    }

    public String value() {
        return this.value;
    }
}
