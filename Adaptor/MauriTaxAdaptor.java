public class MauriTaxAdaptor implements TaxCalculator {
    private MauriTax mt = new MauriTax();

    public double calculateTax( int quantity, double price ) {
        return mt.mauriTax(price, quantity);
    }
}
