import java.util.Scanner;
import java.util.ArrayList;

public class SalesFacade {
    private ShoppingCart cart;
    private ProcessSales processor;
    private Scanner sc;

    public SalesFacade() {
        cart = new ShoppingCart();
        processor = new ProcessSales(null, cart);
        sc = new Scanner( System.in );
    }

    private void print( Object o ) {
        System.out.println( o );
    }

    public void inputGiftCertificate() {
        print( "Enter GiftCertificate ID: " );
        String id = sc.next();
        print( "Enter GifrCertificate Value: " );
        int value = sc.nextInt();
        this.processor.certificate = new GiftCertificate( id, value );
    }

    public void inputItems() {
        ArrayList<ShoppingCart.Item> items;
        print( "Enter number of items: " );
        int size = sc.nextInt();
        items = new ArrayList<ShoppingCart.Item>(size);
        String _name;
        int _price;
        for( int i=0; i<size; i++ ) {
            print("Enter name of item " + (i+1) + ": ");
            _name = sc.next();
            print("Enter price of item " + (i+1) + ": ");
            _price = sc.nextInt();
            items.add(new ShoppingCart.Item(_name, _price));
        }
        processor.cart.items = items;
    }

    public void processSales() {
        processor.process();
    }
}