public class SeniorCitizen extends Customer {
    static {
        SeniorCitizen.discount = 10.0;
    }
    public double getDiscount() { return SeniorCitizen.discount; }
    public void setDiscount( double discount ) { SeniorCitizen.discount = discount; }

    public SeniorCitizen( String name, int age ) {
        this.name = name;
        this.age = age;
    }
}
