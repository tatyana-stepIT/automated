package petproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class Schedule {

    public int startingAt;



    public int finishingAt;
    public boolean isDayOff;
    public ArrayList <Timeslot> timeslots;
    public int number;
    public Date date;
    public ArrayList <Timeslot> bookings;
    public boolean isAvailable;

    public Schedule() {
        bookings  = new ArrayList<>();
        isAvailable = true;
        timeslots = new ArrayList<>();

    }

    public Schedule(int startingAt, int finishingAt, Date date) {
        this.date = date;
        this.startingAt = startingAt;
        this.finishingAt = finishingAt;
        int numberOfSlots =  finishingAt - startingAt;
        timeslots = new ArrayList<>(numberOfSlots);
        for (int i = 0; i < numberOfSlots; i++) {
            timeslots.add(new Timeslot(date, startingAt+i));
        }
        isAvailable = true;
    }

    public int getStartingAt() {
        return startingAt;
    }

    public void setStartingAt(int startingAt) {
        this.startingAt = startingAt;
    }

    public int getFinishingAt() {
        return finishingAt;
    }

    public void setFinishingAt(int finishingAt) {
        this.finishingAt = finishingAt;
    }

    public boolean isDayOff() {
        return isDayOff;
    }

    public void setDayOff(boolean dayOff) {
        isDayOff = dayOff;
    }

    public ArrayList<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(ArrayList<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Timeslot> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Timeslot> bookings) {
        this.bookings = bookings;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "bookings=" + timeslots +
                '}';
    }
}
