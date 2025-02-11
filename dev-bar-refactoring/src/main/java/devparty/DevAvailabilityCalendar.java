package devparty;

import devparty.model.DevData;

import java.time.LocalDate;
import java.util.*;

class DevAvailabilityCalendar {

    private final Map<LocalDate, Integer> numberOfAvailableDevsByDate = new HashMap<>();

    private static final double BOOKING_THRESHOLD = 0.6;

    public DevAvailabilityCalendar(List<DevData> devs) {
        populateNumberOfAvailableDevsByDate(devs);
    }

    private void populateNumberOfAvailableDevsByDate(List<DevData> devs) {
        for (var devData : devs) {
            for (var date : devData.getOnSite()) {
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

    public boolean notEnoughAvailableDevs(List<DevData> devs) {
        return getMaxNumberOfDevs() <= devs.size() * BOOKING_THRESHOLD;
    }
}
