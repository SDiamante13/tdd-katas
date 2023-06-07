package katacombs;

import java.util.Objects;

class Location {

    private final String title;
    private final String mainDescription;
    private final String lookDescription;
    private final Coordinates coordinates;

    Location(String title, String mainDescription, String lookDescription, Coordinates coordinates) {
        this.title = title;
        this.mainDescription = mainDescription;
        this.lookDescription = lookDescription;
        this.coordinates = coordinates;
    }

    public String lookDescription() {
        return lookDescription;
    }

    public Coordinates coordinates() {
        return coordinates;
    }

    public Location withCoordinates(int x, int y) {
        return new Location(title, mainDescription, lookDescription, new Coordinates(x, y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (!Objects.equals(title, location.title)) return false;
        if (!Objects.equals(mainDescription, location.mainDescription))
            return false;
        return Objects.equals(coordinates, location.coordinates);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (mainDescription != null ? mainDescription.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return title + "\n" + mainDescription;
    }
}
