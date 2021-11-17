package petproject;

import java.util.Date;

public class Timeslot {
    public String ID;
    public Date date;
    public int startingAt;
    public int endingAt;
    public static final int LENGTH = 60;
    public boolean isAvailable;

    public Timeslot(Date date, int startingAt) {
        this.date = date;
        this.ID = "ID" + date.getDay() + "." + date.getMonth() + "." + startingAt;
        this.startingAt = startingAt;
        endingAt = startingAt + LENGTH/60;
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Timeslot{" +
                "ID='" + ID + '\'' +
                ", startingAt=" + startingAt +
                ", endingAt=" + endingAt +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
