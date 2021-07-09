/*

You are a fresh analyst deputed to design the software for Decathlon Chain of
Stores in Karnataka. You are informed about the Business Logic of Point of
Sales criteria by Ms.Veronica Lodge, a dynamic business tycoon operating out of
Decathlon Mumbai. She informs you that there are different types of Customers
of Decathlon namely, Regular Customers, Senior Citizens and First Time
Customers. Regular Customers are given a discount of 12%, Senior Citizens 10%
and First Time Customers 15%. Apart from this, based on the sales-index of
previous day, a Store-level discount is determined every day. This is dynamic.
E.g.Rs.100 off for every purchase above Rs.2000. Using the Object Oriented
Principles of Encapsulation, Abstraction, Inheritance, Composition and
Aggregation that you have studied until this semester, give at least two ways
to design this system.

How will you use the Strategy Pattern to tackle the limitations of traditional
Object Oriented Design highlighted in PART A? The design must handle varying
price-schemes having different pricing algorithms. Design & implement.
*/

public class Client {
    public static void main( String[] args ) {
        performPayment(1000.0, "Regular Customer", new RegularCustomer("A", 1), new DayOneStoreLevelDiscount());
        performPayment(3000.0, "Regular Customer", new RegularCustomer("B", 3), new DayTwoStoreLevelDiscount());
        performPayment(1000.0, "Senior Citizen", new SeniorCitizen("A", 1), new DayOneStoreLevelDiscount());
        performPayment(3000.0, "Senior Citizen", new SeniorCitizen("B", 3), new DayTwoStoreLevelDiscount());
        performPayment(1000.0, "First Time Customer", new FirstTimeCustomer("A", 1), new DayOneStoreLevelDiscount());
        performPayment(3000.0, "First Time Customer", new FirstTimeCustomer("B", 3), new DayTwoStoreLevelDiscount());
    }

    public static void performPayment( double price, String customerType, Customer customer, StoreLevelDiscount storeLevelDiscount ) {
        price = storeLevelDiscount.applyDiscount(price);
        System.out.println( customerType + " discount = " + customer.getDiscount() + "%" );
        price = price * ( 1 - customer.getDiscount() / 100.0 );
        System.out.println( "Discount price = " + price );
    }
}
