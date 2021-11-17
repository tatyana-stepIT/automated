package petproject;

abstract class Membership {
    private final int ID;
    private String name;
    private int visitsNum;
    private int price;
    private Customer owner;
    private boolean isActive;
    private Shift shift;

    public Membership(String name){
        this.name = name;
        this.ID = (int) Math.random();
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void activate() {
        setActive(true);
    }

    public void deactivate() {
        setActive(false);
    }

    public void transfer(Customer owner){
        setOwner(owner);
    }

    public void provideDiscount(int discount){
        setPrice((int) (this.price*(100-discount)/100.0));
    }

    public int getID() {
        return ID;
    }

    protected enum Shift{
        MORNING,
        DAY,
        EVENING,
        OUT_OF_PEAKS,
        ANYTIME_WORKDAYS,
        ANYTIME_WEEKEND,
        ANYTIME
    }
}
