package petproject;

public class PremiumPass extends Membership{

    public PremiumPass() {
        super("PremiumPass");
        setPrice(500);
        setActive(true);
        setShift(Shift.ANYTIME);
    }

}