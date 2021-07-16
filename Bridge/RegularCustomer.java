public class RegularCustomer extends Customer {
    public RegularCustomer( String name, int age, DisplayCalculator discountCalculator ) {
        this.name = name;
        this.age = age;
        this.discountCalculator = discountCalculator;
    }

    @Override public void display() {
        System.out.println( "Welcome Regular Customer!" );
        super.display();
    }
}
