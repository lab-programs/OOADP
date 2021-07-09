public abstract class Customer {
    protected String name;
    protected int age;
    protected static double discount;
    public abstract double getDiscount();
    public abstract void setDiscount( double discount );
}
