public abstract class DiscountCalculator {
    protected double discount;
    public double applyDiscount( double amount ) {
        return amount - amount * discount;
    }
}
