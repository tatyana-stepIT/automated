package petproject;

public class BusinessPass extends Membership{

    public BusinessPass() {
        super("BusinessPass");
        setPrice(500);
        setActive(true);
        setShift(Shift.ANYTIME_WORKDAYS);
    }

}