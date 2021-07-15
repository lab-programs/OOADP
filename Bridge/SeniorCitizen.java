public class SeniorCitizen extends Customer {
    public SeniorCitizen( String name, int age, DiscountCalculator displayCalculator ) {
        this.name = name;
        this.age = age;
        this.displayCalculator = displayCalculator;
    }

    @Override public void display() {
        System.out.println( "Welcome Senior Citizen!" );
        super.display();
    }
}
