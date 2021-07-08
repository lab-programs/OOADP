import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> items;
    private TaxCalculator tc;

    public ShoppingCart( TaxCalculator tc ) {
        this.items = new ArrayList<Item>();
        this.tc = tc;
    }

    public void setTaxCalculator( TaxCaculator tc ) { this.tc = tc; }
    public TaxCalculator getTaxCalculator() { return this.tc; }

    public void setItems( ArrayList<Item> items ) { this.items = items; }
    public ArrayList<Item> getItems() { return this.items; }

    public void addItem( String name, int quantity, float price ) {
        items.add( Item( name, quantity, price ) );
    }

    public double calculateTax() {
        double tax = 0.0;
        for( Item item : items ) {
            tax += item.calculateTax(this.tc);
        }
        return tax;
    }
}
