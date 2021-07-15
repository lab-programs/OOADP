public abstract class DiscountCalculator {
    private double discount;
    public double applyDiscount( double amount ) {
        return amount - amount * discount;
    }
}
