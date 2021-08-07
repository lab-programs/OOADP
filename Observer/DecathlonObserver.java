public class DecathlonObserver {
    private DiscountSlab discountSlab;
    
    public DecathlonObserver( DecathlonSubject subject ) {
        this.discountSlab = subject.getDiscountSlab();
        subject.attach(this);
    }

    public void update( DiscountSlab discountSlab ) {
        this.discountSlab = discountSlab;
    }

    private void print( Object o ) { System.out.println( o ); }

    public void display() {
        print( "Festive Discount Details:" );
        print( "Festival: " + this.discountSlab.festival );
        print( "Discount: " + this.discountSlab.discount );
        print( "Start Date: " + this.discountSlab.start );
        print( "End Date: " + this.discountSlab.end );
    }
}