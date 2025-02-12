package devparty.model;

import java.time.LocalDate;
import java.util.*;

public class DevAvailabilityCalendar {

    private final Map<LocalDate, Integer> numberOfAvailableDevsByDate = new HashMap<>();

    private static final double BOOKING_THRESHOLD = 0.6;

    public DevAvailabilityCalendar(List<Dev> devs) {
        populateNumberOfAvailableDevsByDate(devs);
    }

    private void populateNumberOfAvailableDevsByDate(List<Dev> devs) {
        for (var devData : devs) {
            for (var date : devData.onSite()) {
                if (numberOfAvailableDevsByDate.containsKey(date)) {
                    numberOfAvailableDevsByDate.put(date, numberOfAvailableDevsByDate.get(date) + 1);
                } else {
                    numberOfAvailableDevsByDate.put(date, 1);
                }
            }
        }
    }

    public LocalDate determineBestDate(int maxNumberOfDevs) {
        Optional<Map.Entry<LocalDate, Integer>> found = Optional.empty();
        for (Map.Entry<LocalDate, Integer> entry : numberOfAvailableDevsByDate.entrySet()) {
            if (entry.getValue() == maxNumberOfDevs) {
                found = Optional.of(entry);
                break;
            }
        }
        return found
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Integer getMaxNumberOfDevs() {
        return Collections.max(numberOfAvailableDevsByDate.values());
    }

    public boolean notEnoughAvailableDevs(List<Dev> devs) {
        return getMaxNumberOfDevs() <= devs.size() * BOOKING_THRESHOLD;
    }
}
