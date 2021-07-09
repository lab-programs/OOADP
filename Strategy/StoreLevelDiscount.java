public abstract class StoreLevelDiscount {
    protected double minimumPurchase;
    protected double discountAmount;

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
