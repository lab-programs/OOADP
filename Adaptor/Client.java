/*
To establish the 1st Decathlon store in Mauritius, you go along with Mr. Satya Nadella,
an expert in finding 3rd-party partners. For e.g. a 3rd-party Tax- Calculator system
to cater to the specifics of Sales and VAT (Value-added services Tax) tax calculations
in different countries. He finds a 3rd-party Tax-Calculator system called ‘MauriTax’
in Port Louis. The problem is, the APIs used by ‘MauriTax’ for tax-calculation is
fixed & cannot be changed. The ‘MauriTax’ APIs are incompatible with ‘Decathlon POS’.

How will you use the Adaptor Pattern to design & implement?
*/

public class Client {
    public static void main( String[] args ) {
        ShoppingCart sc = new ShoppingCart(new GST());
        System.out.println( " ===== Using GST ===== ");
        System.out.println( "Tax with 0 items: " + sc.calculateTax() );
        System.out.println( "Total with 0 items: " + sc.checkout() );
        sc.addItem( "Cycle", 1, 15000.0 );
        sc.addItem( "GBA", 2, 10000.0 );
        System.out.println( "Tax with 2 items: " + sc.calculateTax() );
        System.out.println( "Total with 2 items: " + sc.checkout() );
        sc = new ShoppingCart(new MauriTaxAdaptor());
        System.out.println( " ===== Using MauriTaxAdaptor ===== ");
        System.out.println( "Tax with 0 items: " + sc.calculateTax() );
        System.out.println( "Total with 0 items: " + sc.checkout() );
        sc.addItem( "Cycle", 1, 15000.0 );
        sc.addItem( "GBA", 2, 10000.0 );
        System.out.println( "Tax with 2 items: " + sc.calculateTax() );
        System.out.println( "Total with 2 items: " + sc.checkout() );
    }
}
