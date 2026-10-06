package tech.pathtoprogramming.gameoflife;

import java.util.HashSet;
import java.util.Set;

final class WorldParser {

    private WorldParser() {
    }

    static World parse(String input) {
        String[] rows = input.split("\n");
        Set<Position> liveCellPositions = new HashSet<>();
        for (int y = 0; y < rows.length; y++) {
            liveCellPositions.addAll(liveCellsInRow(rows[y], y));
        }
        return new World(liveCellPositions);
    }

    private static Set<Position> liveCellsInRow(String input, int y) {
        String inputWithoutSpaces = input.replace(" ", "");

        Set<Position> liveCellPositions = new HashSet<>();
        char[] charArray = inputWithoutSpaces.toCharArray();
        for (int x = 0; x < charArray.length; x++) {
            if (charArray[x] == '#') {
                liveCellPositions.add(new Position(x, y));
            }
        }
        return liveCellPositions;
    }
}
