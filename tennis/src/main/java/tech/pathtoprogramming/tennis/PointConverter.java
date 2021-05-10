package tech.pathtoprogramming.tennis;

import java.util.HashMap;
import java.util.Map;

public class PointConverter {

    private final Map<Integer, String> pointsMap;

    public PointConverter() {
        this.pointsMap = new HashMap<>();
        pointsMap.put(0, "0");
        pointsMap.put(1, "15");
        pointsMap.put(2, "30");
        pointsMap.put(3, "40");
        pointsMap.put(4, "Winner");
    }

    public String convertPointsToScore(Integer points) {
        return pointsMap.get(points);
    }
}
