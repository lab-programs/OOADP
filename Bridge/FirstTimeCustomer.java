public class FirstTimeCustomer extends Customer {
    public FirstTimeCustomer( String name, int age, DiscountCalculator discountCalculator ) {
        this.name = name;
        this.age = age;
        this.discountCalculator = discountCalculator;
    }

    @Override public void display() {
        System.out.println( "Welcome First Time Customer!" );
        super.display();
    }
}
