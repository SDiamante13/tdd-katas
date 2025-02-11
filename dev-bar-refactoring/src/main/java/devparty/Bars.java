package devparty;

import devparty.model.BarData;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

class Bars {

    private final List<BarData> bars;

    public Bars(List<BarData> bars) {
        this.bars = bars;
    }

    public List<BarData> getBars() {
        return bars;
    }

    public Optional<BarData> findFirstAvailableBar(int maxNumberOfDevs, LocalDate bestDate) {
        return getBars().stream()
                .filter(barData -> barData.getCapacity() >= maxNumberOfDevs && barData.getOpen().contains(bestDate.getDayOfWeek()))
                .findFirst();
    }
}
