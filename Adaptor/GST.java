public class GST implements TaxCalculator {
    public double calculateTax( int quantity, double price ) {
        return 0.18 * price * (double) quantity;
    }
}
