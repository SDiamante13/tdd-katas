package devparty;

import devparty.model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class BookingService {


    private final IBarRepository barRepo;
    private final IDevRepository devRepo;
    private final IBoatRepository boatRepo;
    private final IBookingRepository bookingRepo;

    // Goal: Separate I/O from business logic

    // [x] Only One Level Of Indentation Per Method
    // [x] Don’t Use The ELSE Keyword -> guard clause
    // [x] Wrap All Primitives And Strings -> ValueObject -> PhoneNumber (String)
    // [x] First Class Collections
    // [x] One Dot Per Line -> Law of Demeter dog.tail.wag --> dog.wagTail()
    // [x] Don’t Abbreviate
    // [x] Keep All Entities Small - Classes < 50 lines
    // [x] No Classes With More Than Two Instance Variables
    // [x] No Getters/Setters/Properties - Feature Envy code smell


    public BookingService(IBarRepository barRepo, IDevRepository devRepo, IBoatRepository boatRepo, IBookingRepository bookingRepo) {
        this.barRepo = barRepo;
        this.devRepo = devRepo;
        this.boatRepo = boatRepo;
        this.bookingRepo = bookingRepo;
    }

    public boolean reserveBar() {
        var bars = barRepo.get();
        var devs = devRepo.get().stream().toList();
        var boats = boatRepo.get();

        DevAvailabilityCalendar devAvailabilityCalendar = new DevAvailabilityCalendar(devs);

        int maxNumberOfDevs = devAvailabilityCalendar.getMaxNumberOfDevs();

        if (devAvailabilityCalendar.notEnoughAvailableDevs(devs)) {
            return false;
        }

        LocalDate bestDate = devAvailabilityCalendar.determineBestDate(maxNumberOfDevs);

        Optional<BoatData> firstAvailableBoat = findFirstAvailableBoat(boats, maxNumberOfDevs);
        firstAvailableBoat.ifPresent(boatData -> printAndSaveBoatBooking(boatData, bestDate));
        if (firstAvailableBoat.isPresent()) {
            return true;
        }

        Optional<BarData> firstAvailableBar = findFirstAvailableBar(bars, maxNumberOfDevs, bestDate);
        firstAvailableBar.ifPresent(barData -> printAndSaveBooking(barData, bestDate));
        if (firstAvailableBar.isPresent()) {
            return true;
        }

        return false;
    }

    private Optional<BoatData> findFirstAvailableBoat(List<BoatData> boats, int maxNumberOfDevs) {
        return boats.stream().filter(boatData -> new Bar().hasEnoughCapacity(boatData, maxNumberOfDevs)).findFirst();
    }

    private void printAndSaveBoatBooking(BoatData boatData, LocalDate bestDate) {
        System.out.println("Bar booked: " + boatData.getName() + " at " + bestDate);
        bookingRepo.save(new BookingData(
                new BarData(boatData.getName(), boatData.getMaxPeople(), allDays()), bestDate
        ));
    }

    private void printAndSaveBooking(BarData barData, LocalDate bestDate) {
        System.out.println("Bar booked: " + barData.getName() + " at " + bestDate);
        bookingRepo.save(new BookingData(barData, bestDate));
    }

    private Optional<BarData> findFirstAvailableBar(List<BarData> bars, int maxNumberOfDevs, LocalDate bestDate) {
        return bars.stream()
                .filter(barData -> barData.getCapacity() >= maxNumberOfDevs && barData.getOpen().contains(bestDate.getDayOfWeek()))
                .findFirst();
    }

    private static List<DayOfWeek> allDays() {
        return Arrays.asList(DayOfWeek.values());
    }

}