public class SeniorCitizen extends Customer {

    public double getDiscount() { return this.discount; }
    public void setDiscount( double discount ) { this.discount = discount; }

    public SeniorCitizen( String name, int age ) {
        this.name = name;
        this.age = age;
        this.discount = 10;
    }
}
