public class RegularCustomer extends Customer {
    static {
        RegularCustomer.discount = 12.0;
    }

    public double getDiscount() { return RegularCustomer.discount; }
    public void setDiscount( double discount ) { RegularCustomer.discount = discount; }

    public RegularCustomer( String name, int age ) {
        this.name = name;
        this.age = age;
    }
}
