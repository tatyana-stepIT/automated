package petproject;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Reception {

        FitnessClub myFitnessClub;
        Date d;
        Schedule schedule;
        Trainer yogaTrainer0;
        Trainer yogaTrainer1;
        Trainer strengthTrainer0;
        Trainer strengthTrainer1;
        Customer client1;
        Customer client2;

        @Before
        public void init() {
                d = new Date();
                myFitnessClub = new FitnessClub("Strength");
                schedule = new Schedule(8, 23, d);
                myFitnessClub.scheduled.add(schedule);
                yogaTrainer0 = new Trainer("Ann", Gender.FEMALE, Specialization.YOGA, 150);
                yogaTrainer1 = new Trainer("Joe", Gender.MALE, Specialization.YOGA, 120);
                strengthTrainer0 = new Trainer("Mary", Gender.FEMALE, Specialization.STRENGTH, 100);
                strengthTrainer1 = new Trainer("George", Gender.MALE, Specialization.STRENGTH, 100);


                yogaTrainer0.scheduled.add(schedule);
                yogaTrainer1.scheduled.add(schedule);
                strengthTrainer0.scheduled.add(schedule);
                strengthTrainer1.scheduled.add(schedule);

                myFitnessClub.fulfillStaff(yogaTrainer0);
                myFitnessClub.fulfillStaff(yogaTrainer1);
                myFitnessClub.fulfillStaff(strengthTrainer0);
                myFitnessClub.fulfillStaff(strengthTrainer1);

                client1 = new Customer("John", "D.", "070123456", "123456", Customer.TrainingPreference.DOESNTMATTER, 27, Gender.MALE);
                client2 = new Customer("Jane", "D.", "070123457", "123458", Customer.TrainingPreference.MEN, 25, Gender.FEMALE);

                client1.scheduled.add(schedule);
        }


        @Test
        public  void testFitnessClub() {
                myFitnessClub.fulfillClientele(client1);
                myFitnessClub.fulfillClientele(client2);

                System.out.println(myFitnessClub);


                System.out.println(myFitnessClub.getPersonalWorkouts());
        }

        @Test
        public  void testBooking() {
                myFitnessClub.book(d, 12,yogaTrainer0,client1);
                assertEquals("The booking should appear on personalWorkouts", 1,  myFitnessClub.getPersonalWorkouts().size());
                System.out.println(myFitnessClub.getPersonalWorkouts());
//                myFitnessClub.book(d, 12,yogaTrainer0,client1);
//                assertEquals("The duolicated booking should not appear on personalWorkouts", 1,  myFitnessClub.getPersonalWorkouts().size());
        }


}
