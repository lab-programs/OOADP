public class RegularCustomer extends Customer {
    public RegularCustomer( String name, int age, DisplayCalculator displayCalculator ) {
        this.name = name;
        this.age = age;
        this.displayCalculator = displayCalculator;
    }

    @Override public void display() {
        System.out.println( "Welcome Regular Customer!" );
        super.display();
    }
}
