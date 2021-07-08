public class Item {
    private String name;
    private int quantity;
    private double price;

    public Item( String name, int quantity, double price ) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTax( TaxCalculator tc ) {
        return tc.calculateTax(this.quantity, this.price);
    }

    public double calculateTotal( TaxCalculator tc ) {
        return this.quantity * this.price + this.calculateTax(tc);
    }
}
