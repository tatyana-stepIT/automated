package petproject;

import java.util.ArrayList;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String ID;
    private TrainingPreference trainingPreference;
    private int age;
    private Gender gender;
    private boolean isEnrolled;
    private int abonementID;
    public ArrayList<Schedule> scheduled;

    public Customer(String firstName, String lastName, String phone, String ID, TrainingPreference trainingPreference, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.ID = ID;
        this.trainingPreference = trainingPreference;
        this.age = age;
        this.gender = gender;
        isEnrolled = false;
        scheduled = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public TrainingPreference getTrainingPreference() {
        return trainingPreference;
    }

    public void setTrainingPreference(TrainingPreference trainingPreference) {
        this.trainingPreference = trainingPreference;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void setEnrolled(boolean enrolled) {
        isEnrolled = enrolled;
    }

    public int getAbonementID() {
        return abonementID;
    }

    public void setAbonementID(int abonementID) {
        this.abonementID = abonementID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", ID='" + ID + '\'' +
                ", trainingPreference=" + trainingPreference +
                ", age=" + age +
                ", gender=" + gender +
                ", isEnrolled=" + isEnrolled +
                ", abonementID=" + abonementID +
                '}';
    }

    public enum TrainingPreference {
        WOMEN,
        MEN,
        DOESNTMATTER
    }
}
