public abstract class Customer {
    private String name;
    private int age;
    private DiscountCalculator discountCalculator;

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
