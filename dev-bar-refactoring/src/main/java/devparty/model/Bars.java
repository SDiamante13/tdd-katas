package devparty.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Bars {

    private final List<Bar> bars;

    public Bars(List<Bar> bars) {
        this.bars = bars;
    }

    public List<Bar> getBars() {
        return bars;
    }

    public Optional<Bar> findFirstAvailableBar(int maxNumberOfDevs, LocalDate bestDate) {
        return getBars().stream()
                .filter(barData -> barData.capacity() >= maxNumberOfDevs && barData.open().contains(bestDate.getDayOfWeek()))
                .findFirst();
    }
}
