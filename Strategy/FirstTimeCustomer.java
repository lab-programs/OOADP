public class FirstTimeCustomer extends Customer {
    static {
        FirstTimeCustomer.discount = 15.0;
    }

    public double getDiscount() { return FirstTimeCustomer.discount; }
    public void setDiscount( double discount ) { FirstTimeCustomer.discount = discount; }

    public FirstTimeCustomer( String name, int age ) {
        this.name = name;
        this.age = age;
    }
}
