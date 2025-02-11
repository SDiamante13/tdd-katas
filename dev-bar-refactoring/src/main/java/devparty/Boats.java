package devparty;

import devparty.model.Bar;
import devparty.model.BoatData;

import java.util.List;
import java.util.Optional;

class Boats {

    public List<BoatData> boats;

    public Boats(List<BoatData> boats) {
        this.boats = boats;
    }

    public Optional<BoatData> findFirstAvailableBoat(int maxNumberOfDevs) {
        return boats.stream().filter(boatData -> new Bar().hasEnoughCapacity(boatData, maxNumberOfDevs)).findFirst();
    }
}
