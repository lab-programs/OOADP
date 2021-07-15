public abstract class Customer {
    protected String name;
    protected int age;
    protected DiscountCalculator discountCalculator;

    public void display() {
        System.out.println( "Name: " + this.name );
        System.out.println( "Age: " + this.age );
    }

    public void setDiscountCalculator( DiscountCalculator discountCalculator ) {
        this.discountCalculator = discountCalculator;
    }

    public double calculateBill( double amount ) {
        return this.discountCalculator.applyDiscount(amount);
    }
}
