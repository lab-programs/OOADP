public class Client {
    public static void main( String[] args ) {
        TestCustomer( new Kid("A", 1) );
        TestCustomer( new Teen("B", 13) );
        TestCustomer( new Adult("C", 18) );
        TestCustomer( new Senior("D", 61) );
    }

    public static void TestCustomer( Customer customer ) {
        System.out.println("-------------------------");
        customer.details();
        System.out.println("-------------------------");
    }
}