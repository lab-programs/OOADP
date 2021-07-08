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
        Customer myCustomer = new RegularCustomer();
        System.out.println( "Regular customer discount = " + myCustomer.getDiscount() );

        myCustomer = new SeniorCitizen();
        System.out.println( "Senior Citizen discount = " + myCustomer.getDiscount() );

        myCustomer = new FirstTimeCustomer();
        System.out.println( "First Time Customer discount = " + myCustomer.getDiscount() );
    }
}
