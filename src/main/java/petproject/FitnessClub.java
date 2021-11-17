package petproject;

import java.util.*;

public class FitnessClub {

    public String name;

    private ArrayList <Trainer> staff;
    private ArrayList <Customer> clientele;
    private LinkedList <Schedule> workingHours;
    private HashMap <Membership, Customer> enrollments;
    private HashMap <Timeslot, Workout> workouts;
    private LinkedList <Booking> personalWorkouts;
    private HashMap <Schedule, Trainer> duty;
    public ArrayList<Schedule> scheduled;

    public FitnessClub(String name) {
        this.name = name;
        staff = new ArrayList<Trainer>();
        clientele = new ArrayList<Customer>();
        scheduled = new ArrayList<>();
        personalWorkouts = new LinkedList<>();
    }

    public ArrayList<Trainer> getStaff() {
        return staff;
    }

    public void fulfillStaff(Trainer trainer) {
        boolean wasHere = false;
        for (Trainer t: staff) {
            if (t.name.equals(trainer.name)) {
                System.out.println("duplicate");
                wasHere = true;
                break;
            }
        }
        if (!wasHere) {
            staff.add(trainer);
        }
    }

    public ArrayList<Customer> getClientele() {
        return clientele;
    }

    public void fulfillClientele(Customer client) {
        clientele.add(client);
    }

    public LinkedList <Schedule> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(LinkedList <Schedule> workingHours) {
        this.workingHours = workingHours;
    }

    public HashMap<Membership, Customer> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(HashMap<Membership, Customer> enrollments) {
        this.enrollments = enrollments;
    }

    public HashMap<Schedule, Trainer> getDuty() {
        return duty;
    }

    public void setDuty(HashMap<Schedule, Trainer> duty) {
        this.duty = duty;
    }

    public void createSchedule(Date date) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter start time");
        int startingAt = in.nextInt();
        System.out.println("Enter end time");
        int finishingAt = in.nextInt();
        Schedule result = new Schedule(startingAt,finishingAt,date);
        for (int i = 0; i < finishingAt - startingAt; i++) {
            result.timeslots.add(new Timeslot(date, startingAt+i));
        }
        workingHours.add(result);
    }

    public void book(Date date, int startingAt, Trainer trainer, Customer customer) {
        for (Schedule s: scheduled) {
            if (s.date == date && s.isAvailable) {
                for (Timeslot t : s.timeslots) {
                    if (t.startingAt == startingAt) {
                        personalWorkouts.add(new Booking(t, trainer, customer));
                        break;
                    }
                }
            } else {
                System.out.println("No available schedule for this date");
            }
        }
    }

    public void showClosestAvailableSlot(Date date) {
        //iterator
        for (Schedule s:
                scheduled) {
            if (s.date == date && s.isAvailable == true)
                System.out.println(s.startingAt);
        }
    }

    @Override
    public String toString() {
        return "FitnessClub{" +
                "name='" + name + '\'' +
                ", staff=" + staff +
                ", clientele=" + clientele +
                ", workingHours=" + workingHours +
                ", enrollments=" + enrollments +
                ", workouts=" + workouts +
                ", duty=" + duty +
                '}';
    }

    public LinkedList<Booking> getPersonalWorkouts() {
        return personalWorkouts;
    }

    public void setPersonalWorkouts(LinkedList<Booking> personalWorkouts) {
        this.personalWorkouts = personalWorkouts;
    }
}
