public class RegularCustomer extends Customer {

    public double getDiscount() { return this.discount; }
    public void setDiscount( double discount ) { this.discount = discount; }

    public RegularCustomer( String name, int age ) {
        this.name = name;
        this.age = age;
        this.discount = 12.0;
    }
}
