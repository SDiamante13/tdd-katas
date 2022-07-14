package tech.pathtoprogramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Spaces {

    private List<Property> spaces;

    public Spaces() {
        spaces = new ArrayList<>();
        spaces.addAll(
                List.of(
                        new Property("GO", 200),
                        new Property("Mediterranean Avenue",60) ,
                        new Property("Community Chest",0),
                        new Property("Baltic Avenue", 60),
                        new Property("Income Tax",0),
                        new Property("Reading Railroad", 200),
                        new Property("Oriental Avenue", 100),
                        new Property("Chance",0),
                        new Property("Vermont Avenue",0),
                        new Property("Connecticut Avenue",0),
                        new Property("Jail / Just Visiting",0),
                        new Property("St. Charles Place", 140),
                        new Property("Electric Company",0),
                        new Property("States Avenue",0),
                        new Property("Virginia Avenue",0),
                        new Property("Pennsylvania Railroad",200),
                        new Property("St. James Place",0),
                        new Property("Community Chest",0),
                        new Property("Tennessee Avenue",0),
                        new Property("New York Avenue",0),
                        new Property("Free Parking",0),
                        new Property("Kentucky Avenue",0),
                        new Property("Chance",0),
                        new Property("Indiana Avenue",0),
                        new Property("Illinois Avenue",0),
                        new Property("B. & O. Railroad",200),
                        new Property("Atlantic Avenue",0),
                        new Property("Ventnor Avenue",0),
                        new Property("Water Works",0),
                        new Property("Marvin Gardens",0),
                        new Property("Go To Jail",0),
                        new Property("Pacific Avenue",0),
                        new Property("North Carolina Avenue",0),
                        new Property("Community Chest",0),
                        new Property("Pennsylvania Avenue",0),
                        new Property("Short Line",0),
                        new Property("Chance",0),
                        new Property("Park Place",0),
                        new Property("Luxury Tax",0),
                        new Property("Boardwalk",400)
                )
        );
    }

    public Property at(int location) {
        return spaces.get(location);
    }
}
