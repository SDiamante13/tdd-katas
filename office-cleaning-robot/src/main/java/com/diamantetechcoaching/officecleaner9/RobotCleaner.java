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
                moveNorth(steps);
                break;
            case 'S':
                moveSouth(steps);
                break;
            case 'E':
                moveEast(steps);
                break;
            case 'W':
                moveWest(steps);
                break;
        }
    }

    private void moveNorth(int steps) {
        for (int i = 0; i < steps; i++) {
            //if robot is at the boundary of the floor it just stops there and wait for next direction
            if (currentY + 1 > FLOOR_UPPER_LENGTH) {
                currentY = FLOOR_UPPER_LENGTH;
                break;
            } else {
                //if place is not visited
                if (!visitedPlaces.containsKey(String.format("%s %s", currentX, currentY + 1))) {
                    //Visit it and add to the visited places
                    visitedPlaces.put(String.format("%s %s", currentX, currentY + 1), new Coordinate(currentX, ++currentY));
                } else {
                    //otherwise moves to the next location
                    ++currentY;
                }
            }
        }
    }

    private void moveSouth(int steps) {
        for (int i = 0; i < steps; i++) {
            //if robot is at the boundary of the floor it just stops there and wait for next direction
            if (currentY - 1 < FLOOR_LOWER_LENGTH) {
                currentY = FLOOR_LOWER_LENGTH;
                break;
            } else {
                //if place is not visited
                if (!visitedPlaces.containsKey(String.format("%s %s", currentX, currentY - 1))) {
                    //Visit it and add to the visited places
                    visitedPlaces.put(String.format("%s %s", currentX, currentY - 1), new Coordinate(currentX, --currentY));
                } else {
                    //otherwise moves to the next location
                    --currentY;
                }
            }
        }
    }

    private void moveEast(int steps) {
        for (int i = 0; i < steps; i++) {
            //if robot is at the boundary of the floor it just stops there and wait for next direction
            if (currentX - 1 < FLOOR_LOWER_WIDTH) {
                currentX = FLOOR_LOWER_WIDTH;
                break;
            } else {
                //if place is not visited
                if (!visitedPlaces.containsKey(String.format("%s %s", currentX - 1, currentY))) {
                    //Visit it and add to the visited places
                    visitedPlaces.put(String.format("%s %s", currentX - 1, currentY), new Coordinate(--currentX, currentY));
                } else {
                    //otherwise moves to the next location
                    --currentX;
                }
            }
        }
    }

    private void moveWest(int steps) {
        for (int i = 0; i < steps; i++) {
            //if robot is at the boundary of the floor it just stops there and wait for next direction
            if (currentX + 1 > FLOOR_UPPER_WIDTH) {
                currentX = FLOOR_UPPER_WIDTH;
                break;
            } else {
                //if place is not visited
                if (!visitedPlaces.containsKey(String.format("%s %s", currentX + 1, currentY))) {
                    //Visit it and add to the visited places
                    visitedPlaces.put(String.format("%s %s", currentX + 1, currentY), new Coordinate(++currentX, currentY));
                } else {
                    //otherwise moves to the next location
                    ++currentX;
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
