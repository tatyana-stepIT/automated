package petproject;

import java.util.ArrayList;

public class Trainer {

    private boolean isAvailable;
    public String name;
    public Gender gender;
    public Specialization specialty;
    public int salaryPerHour;
    private boolean isQualified;
    private boolean isOnVacation;
    public ArrayList<Schedule> scheduled;

    public Trainer(String name, Gender gender, Specialization specialty, int salaryPerHour) {
        this.name = name;
        this.gender = gender;
        this.specialty = specialty;
        this.salaryPerHour = salaryPerHour;
        scheduled = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "isAvailable=" + isAvailable +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", specialty=" + specialty +
                ", salaryPerHour=" + salaryPerHour +
                ", isQualified=" + isQualified +
                ", isOnVacation=" + isOnVacation +
                '}';
    }
}
