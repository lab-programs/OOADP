public class SeniorCitizen extends Customer {
    public SeniorCitizen( String name, int age, DiscountCalculator discountCalculator ) {
        this.name = name;
        this.age = age;
        this.discountCalculator = discountCalculator;
    }

    @Override public void display() {
        System.out.println( "Welcome Senior Citizen!" );
        super.display();
    }
}
