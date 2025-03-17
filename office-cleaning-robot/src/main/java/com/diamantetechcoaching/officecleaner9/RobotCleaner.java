package com.diamantetechcoaching.officecleaner9;

import java.util.TreeMap;

public class RobotCleaner {
    /**
     * Directions NEWS = North, East, West, South
     */
    final String DIRECTIONS = "NEWS";
    /**
     * Maximum number of steps
     */
    final int MAX_STEPS = 100000;

    private static final int FLOOR_UPPER_WIDTH = 100_000;
    private static final int FLOOR_LOWER_WIDTH = -100_000;
    private static final int FLOOR_UPPER_LENGTH = 100_000;
    private static final int FLOOR_LOWER_LENGTH = -100_000;

    private int currentX;
    private int currentY;

    public class Coordinates {
        public int x;
        public int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String ToString() {
            return "[" + this.x + ", " + this.y + ", Visit]";
        }
    }

    /**
     * Sorted List(for fast searching) of visited spaces(coordinates) on floor.
     */
    public TreeMap<String, Coordinates> visitedPlaces = new TreeMap<String, Coordinates>();

    public RobotCleaner() {
    }

    /**
     * Starts the robot at given location and Visit it
     */
    public void StartAt(int X, int Y) {
        currentX = X;
        currentY = Y;
        //Visited start position,  (Key  = CURRENT_X + CURRENT_Y) for searching
        visitedPlaces.put(String.format("%s %s", currentX, currentY), new Coordinates(currentX, currentY));
    }

    /**
     * Visits the floor
     * in direction
     * with number of steps
     */
    public void CleanFloor(char direction, int steps) {
        if (!DIRECTIONS.contains("" + direction))
            return;
        if (steps < 0 || steps > MAX_STEPS)
            return;
        switch (direction) {
            case 'N':
                for (int i = 0; i < steps; i++) {
                    //if robot is at the boundary of the floor it just stops there and wait for next direction
                    if (currentY + 1 > FLOOR_UPPER_LENGTH) {
                        currentY = FLOOR_UPPER_LENGTH;
                        break;
                    } else {
                        //if place is not visited
                        if (!visitedPlaces.containsKey(String.format("%s %s", currentX, currentY + 1))) {
                            //Visit it and add to the visited places
                            visitedPlaces.put(String.format("%s %s", currentX, currentY + 1), new Coordinates(currentX, ++currentY));
                        } else {
                            //otherwise moves to the next location
                            ++currentY;
                        }
                    }
                }
                break;
            case 'S':
                for (int i = 0; i < steps; i++) {
                    //if robot is at the boundary of the floor it just stops there and wait for next direction
                    if (currentY - 1 < FLOOR_LOWER_LENGTH) {
                        currentY = FLOOR_LOWER_LENGTH;
                        break;
                    } else {
                        //if place is not visited
                        if (!visitedPlaces.containsKey(String.format("%s %s", currentX, currentY - 1))) {
                            //Visit it and add to the visited places
                            visitedPlaces.put(String.format("%s %s", currentX, currentY - 1), new Coordinates(currentX, --currentY));
                        } else {
                            //otherwise moves to the next location
                            --currentY;
                        }
                    }
                }
                break;
            case 'E':
                for (int i = 0; i < steps; i++) {
                    //if robot is at the boundary of the floor it just stops there and wait for next direction
                    if (currentX - 1 < FLOOR_LOWER_WIDTH) {
                        currentX = FLOOR_LOWER_WIDTH;
                        break;
                    } else {
                        //if place is not visited
                        if (!visitedPlaces.containsKey(String.format("%s %s", currentX - 1, currentY))) {
                            //Visit it and add to the visited places
                            visitedPlaces.put(String.format("%s %s", currentX - 1, currentY), new Coordinates(--currentX, currentY));
                        } else {
                            //otherwise moves to the next location
                            --currentX;
                        }
                    }
                }
                break;
            case 'W':
                for (int i = 0; i < steps; i++) {
                    //if robot is at the boundary of the floor it just stops there and wait for next direction
                    if (currentX + 1 > FLOOR_UPPER_WIDTH) {
                        currentX = FLOOR_UPPER_WIDTH;
                        break;
                    } else {
                        //if place is not visited
                        if (!visitedPlaces.containsKey(String.format("%s %s", currentX + 1, currentY))) {
                            //Visit it and add to the visited places
                            visitedPlaces.put(String.format("%s %s", currentX + 1, currentY), new Coordinates(++currentX, currentY));
                        } else {
                            //otherwise moves to the next location
                            ++currentX;
                        }
                    }
                }
                break;
        }
    }

    public void PrintVisitedPlaces() {

        var result = "";
        for (var spot : visitedPlaces.values()) {
            result += spot.ToString();
            result += "\n";
        }
        //System.out.println(result);

    }
}
