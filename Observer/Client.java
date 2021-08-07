public class Client {
    private static void print( Object o ) {
        System.out.println( o );
    }
    public static void main( String[] args ) {
        DiscountSlab discount = new DiscountSlab( 10, "Diwali", "06-11-21", "09-11-21" );
        DecathlonSubject sale = new DecathlonSubject( discount );

        DecathlonObserver indiaCustomer = new DecathlonObserver(sale);
        DecathlonObserver sriLankaCustomer = new DecathlonObserver(sale);

        print( "-----------------DIWALI-----------------");
        print( "For Indian Customers: " );
        indiaCustomer.display();
        print( "For Sri Lankan Customers: " );
        sriLankaCustomer.display();

        discount = new DiscountSlab( 15, "Christmas", "24-12-21", "25-12-21" );
        sale.setDiscountSlab(discount);

        print( "---------------CHRISTMAS----------------");
        print( "For Indian Customers: " );
        indiaCustomer.display();
        print( "For Sri Lankan Customers: " );
        sriLankaCustomer.display();
    }
}