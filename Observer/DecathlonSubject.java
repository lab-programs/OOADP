import java.util.ArrayList;

public class DecathlonSubject {
    private DiscountSlab discountSlab;
    private ArrayList<DecathlonObserver> observers;

    public DecathlonSubject( DiscountSlab discountSlab ) {
        this.discountSlab = discountSlab;
        this.observers = new ArrayList<DecathlonObserver>();
    }

    public void attach( DecathlonObserver decathlonObserver ) { observers.add( decathlonObserver ); }
    
    public void notifyObservers() {
        for( DecathlonObserver observer: observers ) {
            observer.update(this.discountSlab);
        }
    }
    public DiscountSlab getDiscountSlab() { return this.discountSlab; }
    public void setDiscountSlab( DiscountSlab discountSlab ) { 
        this.discountSlab = discountSlab; 
        this.notifyObservers();
    }
}