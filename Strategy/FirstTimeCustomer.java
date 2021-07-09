public class FirstTimeCustomer extends Customer {

    public double getDiscount() { return this.discount; }
    public void setDiscount( double discount ) { this.discount = discount; }

    public FirstTimeCustomer( String name, int age ) {
        this.name = name;
        this.age = age;
        this.discount = 15.0;
    }
}
