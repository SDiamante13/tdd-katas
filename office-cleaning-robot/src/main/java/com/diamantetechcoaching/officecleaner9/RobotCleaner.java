package com.diamantetechcoaching.officecleaner9;

import java.util.Map;
import java.util.TreeMap;

public class RobotCleaner {
    /**
     * Directions NEWS = North, East, West, South
     */
    private static final String DIRECTIONS = "NEWS";
    /**
     * Maximum number of steps
     */
    private static final int MAX_STEPS = 100000;

    private static final int FLOOR_UPPER_WIDTH = 100_000;
    private static final int FLOOR_LOWER_WIDTH = -100_000;
    private static final int FLOOR_UPPER_LENGTH = 100_000;
    private static final int FLOOR_LOWER_LENGTH = -100_000;

    private int currentX;
    private int currentY;

    /**
     * Sorted List(for fast searching) of visited spaces(coordinates) on floor.
     */
    public Map<String, Coordinate> visitedPlaces = new TreeMap<>();

    /**
     * Starts the robot at given location and Visit it
     */
    public void startAt(int x, int y) {
        currentX = x;
        currentY = y;
        //Visited start position,  (Key  = CURRENT_X + CURRENT_Y) for searching
        visitedPlaces.put(String.format("%s %s", currentX, currentY), new Coordinate(currentX, currentY));
    }

    /**
     * Visits the floor
     * in direction
     * with number of steps
     */
    public void cleanFloor(char direction, int steps) {
        if (!DIRECTIONS.contains("" + direction) || steps < 0 || steps > MAX_STEPS) {
            return;
        }
        moveAcrossFloor(direction, steps);
    }

    private void moveAcrossFloor(char direction, int steps) {
        switch (direction) {
            case 'N':
                moveVertically(steps, 1, FLOOR_UPPER_LENGTH);
                break;
            case 'S':
                moveVertically(steps, -1, FLOOR_LOWER_LENGTH);
                break;
            case 'E':
                moveHorizontally(steps, -1, FLOOR_LOWER_WIDTH);
                break;
            case 'W':
                moveHorizontally(steps, 1, FLOOR_UPPER_WIDTH);
                break;
        }
    }

    private void moveVertically(int steps, int direction, int boundary) {
        for (int i = 0; i < steps; i++) {
            int next = currentY + direction;
            if ((direction == -1 && next < boundary) || (direction == 1 && next > boundary)) {
                currentY = boundary;
                break;
            } else {
                if (!visitedPlaces.containsKey(String.format("%s %s", currentX, next))) {
                    visitedPlaces.put(String.format("%s %s", currentX, next), new Coordinate(currentX, currentY));
                    currentY = next;
                } else {
                    currentY = next;
                }
            }
        }
    }

    private void moveHorizontally(int steps, int direction, int boundary) {
        for (int i = 0; i < steps; i++) {
            int next = currentX + direction;
            if ((direction == -1 && next < boundary) || (direction == 1 && next > boundary)) {
                currentX = boundary;
                break;
            } else {
                if (!visitedPlaces.containsKey(String.format("%s %s", next, currentY))) {
                    visitedPlaces.put(String.format("%s %s", next, currentY), new Coordinate(currentX, currentY));
                    currentX = next;
                } else {
                    currentX = next;
                }
            }
        }
    }

    public void PrintVisitedPlaces() {

        var result = "";
        for (var spot : visitedPlaces.values()) {
            result += spot.toString();
            result += "\n";
        }
        //System.out.println(result);

    }
}
