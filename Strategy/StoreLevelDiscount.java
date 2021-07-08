public class StoreLevelDiscount {
    private double minimumPurchase = 2000.0;
    private double discountAmount = 100.0;

    public double getMinimumPurchase() { return this.minimumPurchase; }
    public void setMinimumPurchase( double minimumPurchase ) { this.minimumPurchase = minimumPurchase; }

    public double getDiscountAmount() { return this.discountAmount; }
    public void setDiscountAmount( double discountAmount ) { this.discountAmount = discountAmount; }

    public double applyDiscount( double price ) {
        if( price > minimumPurchase ) {
            return price - discountAmount;
        }
        return price;
    }
}
