package petproject;

import java.util.Date;

public class Booking {

    public Timeslot timeslot;
    public Trainer trainer;
    public Customer customer;

    public Booking(Timeslot timeslot, Trainer trainer, Customer customer) {
        setTimeslot(timeslot);
        setTrainer(trainer,timeslot);
        setCustomer(customer, timeslot);
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        if (timeslot.isAvailable()) {
            this.timeslot = timeslot;
            timeslot.setAvailable(false);
        } else {
            System.out.println("Chosen timeslot is not available");
        }
    }

    public Trainer getTrainer() {
        return trainer;
    }


    public void setTrainer(Trainer trainer, Timeslot timeslot) {
        boolean isAvailable = false;
        for (Timeslot t: trainer.scheduled.get(0).timeslots) {
            if (t.ID.equals(timeslot.ID)) {
                isAvailable = true;
                break;
            }
        }
        if (isAvailable) {
            this.trainer = trainer;
        }
    }

    public void setCustomer(Customer customer, Timeslot timeslot) {
        boolean isAvailable = false;
        for (Timeslot t: customer.scheduled.get(0).timeslots) {
            if (t.ID.equals(timeslot.ID)) {
                isAvailable = true;
                break;
            }
        }
        if (isAvailable) {
            this.customer = customer;
        }
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer1(Customer customer, Timeslot timeslot) {
        boolean isBookable = false;
        Date date = timeslot.date;
        int startingAt = timeslot.startingAt;
        for (Schedule s: customer.scheduled) {
            if (s.date == date && s.isAvailable) {
                for (Timeslot t : s.timeslots) {
                    if (t.startingAt != startingAt || !t.isAvailable) {
                        continue;
                    } else {
                        isBookable = true;
                    }
                }
            }
        }
        if (isBookable) {
            this.customer = customer;
        } else {
            System.out.println("Chosen customer already has booked this time");
        }
    }

    @Override
    public String toString() {
        return "Booking: {" +
                " timeslot:" + timeslot +
                ", trainer:" + trainer +
                ", customer:" + customer +
                '}';
    }
}
