package devparty.model;

import java.util.List;
import java.util.Optional;

public class Boats {

    public List<Boat> boats;

    public Boats(List<Boat> boats) {
        this.boats = boats;
    }

    public Optional<Boat> findFirstAvailableBoat(int maxNumberOfDevs) {
        return boats.stream().filter(boatData -> boatData.hasEnoughCapacity(maxNumberOfDevs)).findFirst();
    }
}
