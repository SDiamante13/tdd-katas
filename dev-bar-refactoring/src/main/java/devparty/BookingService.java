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

    // [/] Only One Level Of Indentation Per Method
    // [x] Don’t Use The ELSE Keyword -> guard clause
    // [x] Wrap All Primitives And Strings -> ValueObject -> PhoneNumber (String)
    // [/] First Class Collections
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
        var barDataList = barRepo.get();
        var devs = devRepo.get().stream().toList();
        var boatDataList = boatRepo.get();

        DevAvailabilityCalendar devAvailabilityCalendar = new DevAvailabilityCalendar(devs);
        int maxNumberOfDevs = devAvailabilityCalendar.getMaxNumberOfDevs();

        if (devAvailabilityCalendar.notEnoughAvailableDevs(devs)) {
            return false;
        }

        LocalDate bestDate = devAvailabilityCalendar.determineBestDate(maxNumberOfDevs);

        Boats boats = new Boats(boatDataList);
        Optional<Boat> firstAvailableBoat = boats.findFirstAvailableBoat(maxNumberOfDevs);
        firstAvailableBoat.ifPresent(boatData -> printAndSaveBoatBooking(boatData, bestDate));
        if (firstAvailableBoat.isPresent()) {
            return true;
        }

        Bars bars = new Bars(barDataList);
        Optional<Bar> firstAvailableBar = bars.findFirstAvailableBar(maxNumberOfDevs, bestDate);
        firstAvailableBar.ifPresent(barData -> printAndSaveBooking(barData, bestDate));
        if (firstAvailableBar.isPresent()) {
            return true;
        }

        return false;
    }

    private void printAndSaveBoatBooking(Boat boat, LocalDate bestDate) {
        System.out.println("Bar booked: " + boat.name() + " at " + bestDate);
        bookingRepo.save(new BookingData(
                new Bar(boat.name(), boat.maxPeople(), allDays()), bestDate
        ));
    }

    private void printAndSaveBooking(Bar bar, LocalDate bestDate) {
        System.out.println("Bar booked: " + bar.name() + " at " + bestDate);
        bookingRepo.save(new BookingData(bar, bestDate));
    }

    private static List<DayOfWeek> allDays() {
        return Arrays.asList(DayOfWeek.values());
    }

}