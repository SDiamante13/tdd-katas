package katacombs;

class Location {

    private final String title;
    private final String mainDescription;
    private final Coordinates coordinates;

    Location(String title, String mainDescription, Coordinates coordinates) {
        this.title = title;
        this.mainDescription = mainDescription;
        this.coordinates = coordinates;
    }

    public Coordinates coordinates() {
        return coordinates;
    }

    public Location withCoordinates(int x, int y) {
        return new Location(title, mainDescription, new Coordinates(x, y));
    }

    @Override
    public String toString() {
        return title + "\n" + mainDescription;
    }
}
