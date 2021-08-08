public class Client {
    public static void main(String[] args) {
        SalesFacade sales = new SalesFacade();
        sales.inputGiftCertificate();
        sales.inputItems();
        sales.processSales();
    }
}
