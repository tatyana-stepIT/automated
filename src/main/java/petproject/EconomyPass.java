package petproject;

public class EconomyPass extends Membership{

    public EconomyPass() {
        super("EconomyPass");
        setPrice(500);
        setActive(true);
        setShift(Shift.OUT_OF_PEAKS);
    }

}
