public class ProcessSales {
    GiftCertificate certificate = null;
    ShoppingCart cart;

    public ProcessSales( ShoppingCart cart ) {
        this.cart = cart;
    }
    public ProcessSales( GiftCertificate certificate, ShoppingCart cart ) {
        this.certificate = certificate;
        this.cart = cart;
    }

    private void print( Object o ) {
        System.out.println( o );
    }
    public void process() {
        if( this.certificate == null ) {
            print( "You don't have the gift certificate. " );
            print( " You have to pay amount: " + this.cart.totalAmount() );
        }
        else if( this.cart.items.size() > 1 ) {
            print( "You have bought more than one item. ");
            print( "You can not apply gift certificate. ");
            print( "You have to pay amount: " + this.cart.totalAmount() );
        }
        else if( this.cart.items.size() <= 0 ) {
            print( "You have not bought any items." );
        }
        else if( this.cart.totalAmount() <= this.certificate.getValue() ) {
            print( "You don't have to pay for this. It will be deducted from your gift card." );
            print( "Your Gift Certificate " + this.certificate.getID() + " Applied." );
            this.certificate.setValue( this.certificate.getValue() - this.cart.totalAmount() );
            print( "Your Gift Certificate Balance: " + this.certificate.getValue() );
            print( "No cashback is provided." );
        }
        else {
            print( "Your Gift Certificate " + this.certificate.getID() + " Applied." );
            int remainingAmount = this.cart.totalAmount() - this.certificate.getValue();
            this.certificate.setValue(0);
            print( "Your Gift Certificate Balance: " + this.certificate.getValue() );
            print( "You have to pay amount: " + remainingAmount + " using cash only.");
        }

    }
}