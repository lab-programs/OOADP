import java.util.ArrayList;

public class ShoppingCart {
    public static class Item {
        String name;
        int price;
        public Item( String name, int price ) {
            this.name = name;
            this.price = price;
        }
    }
    ArrayList<Item> items;

    public ShoppingCart() {
        items = new ArrayList<Item>();
    }

    public ShoppingCart( ArrayList<Item> items ) {
        this.items = items;
    }

    public void addItem( String name, int price ) {
        this.items.add( new Item(name, price) );
    }

    public int totalAmount() {
        int _totalAmount = 0;
        for( Item item: items ) {
            _totalAmount += item.price;
        }
        return _totalAmount;
    }
}