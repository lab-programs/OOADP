# OOADP

## Part B Programs

### 1. Adaptor (Structural)

#### Question

**Adaptor (Structural):** To establish the 1st Decathlon store in Mauritius, you go along
with Mr. Satya Nadella, an expert in finding 3rd-party partners. For e.g. a 3rd-party 
TaxCalculator system to cater to the specifics of Sales and VAT (Value-added services Tax)
tax calculations in different countries. He finds a 3rd-party Tax-Calculator system called
‘MauriTax’ in Port Louis. The problem is, the APIs used by ‘MauriTax’ for tax-calculation
is fixed & cannot be changed. The ‘MauriTax’ APIs are incompatible with ‘Decathlon
POS’. How will you use the Adaptor Pattern to design & implement?

#### Program

```java
// TaxCalculator.java
public interface TaxCalculator {
    public double calculateTax( int quantity, double price );
}
// MauriTax.java
public class MauriTax {
    public double mauriTax( double price, int quantity ) {
        return 0.14 * price * (double) quantity;
    }
}
// GST.java
public class GST implements TaxCalculator {
    public double calculateTax( int quantity, double price ) {
        return 0.18 * price * (double) quantity;
    }
}
// MauriTaxAdaptor.java
public class MauriTaxAdaptor implements TaxCalculator {
    private MauriTax mt = new MauriTax();

    public double calculateTax( int quantity, double price ) {
        return mt.mauriTax(price, quantity);
    }
}
// Item.java
public class Item {
    private String name;
    private int quantity;
    private double price;

    public Item( String name, int quantity, double price ) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTax( TaxCalculator tc ) {
        return tc.calculateTax(this.quantity, this.price);
    }

    public double calculateTotal( TaxCalculator tc ) {
        return this.quantity * this.price + this.calculateTax(tc);
    }
}
// ShoppingCart.java
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> items;
    private TaxCalculator tc;

    public ShoppingCart( TaxCalculator tc ) {
        this.items = new ArrayList<Item>();
        this.tc = tc;
    }

    public void setTaxCalculator( TaxCalculator tc ) { this.tc = tc; }
    public TaxCalculator getTaxCalculator() { return this.tc; }

    public void setItems( ArrayList<Item> items ) { this.items = items; }
    public ArrayList<Item> getItems() { return this.items; }

    public void addItem( String name, int quantity, double price ) {
        items.add( new Item( name, quantity, price ) );
    }

    public double calculateTax() {
        double tax = 0.0;
        for( Item item : items ) {
            tax += item.calculateTax(this.tc);
        }
        return tax;
    }

    public double checkout() {
        double total = 0.0;
        for( Item item: items ) {
            total += item.calculateTotal(this.tc);
        }
        return total;
    }
}
// Client.java
public class Client {
    public static void main( String[] args ) {
        ShoppingCart sc = new ShoppingCart(new GST());
        System.out.println( " ===== Using GST ===== ");
        System.out.println( "Tax with 0 items: " + sc.calculateTax() );
        System.out.println( "Total with 0 items: " + sc.checkout() );
        sc.addItem( "Cycle", 1, 15000.0 );
        sc.addItem( "GBA", 2, 10000.0 );
        System.out.println( "Tax with 2 items: " + sc.calculateTax() );
        System.out.println( "Total with 2 items: " + sc.checkout() );

        sc.setTaxCalculator(new MauriTaxAdaptor());
        System.out.println( " ===== Using MauriTaxAdaptor ===== ");
        System.out.println( "Tax with 0 items: " + sc.calculateTax() );
        System.out.println( "Total with 0 items: " + sc.checkout() );
        System.out.println( "Tax with 2 items: " + sc.calculateTax() );
        System.out.println( "Total with 2 items: " + sc.checkout() );
    }
}
```

### 2. Strategy (Behavioural)

#### Question

**Strategy (Behavioural):** How will you use the Strategy Pattern to tackle the limitations
of traditional Object Oriented Design highlighted in PART A? The design must handle
varying price-schemes having different pricing algorithms. Design & implement.

#### Program

```java
// Customer.java
public abstract class Customer {
    protected String name;
    protected int age;
    protected static double discount;
    public abstract double getDiscount();
    public abstract void setDiscount( double discount );
}
// RegularCustomer.java
public class RegularCustomer extends Customer {
    static {
        RegularCustomer.discount = 12.0;
    }

    public double getDiscount() { return RegularCustomer.discount; }
    public void setDiscount( double discount ) { RegularCustomer.discount = discount; }

    public RegularCustomer( String name, int age ) {
        this.name = name;
        this.age = age;
    }
}
// FirstTimeCustomer.java
public class FirstTimeCustomer extends Customer {
    static {
        FirstTimeCustomer.discount = 15.0;
    }

    public double getDiscount() { return FirstTimeCustomer.discount; }
    public void setDiscount( double discount ) { FirstTimeCustomer.discount = discount; }

    public FirstTimeCustomer( String name, int age ) {
        this.name = name;
        this.age = age;
    }
}
// SeniorCitizen.java
public class SeniorCitizen extends Customer {
    static {
        SeniorCitizen.discount = 10.0;
    }
    public double getDiscount() { return SeniorCitizen.discount; }
    public void setDiscount( double discount ) { SeniorCitizen.discount = discount; }

    public SeniorCitizen( String name, int age ) {
        this.name = name;
        this.age = age;
    }
}
// StoreLevelDiscount.java
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
// DayOneStoreLevelDiscount.java
public class DayOneStoreLevelDiscount extends StoreLevelDiscount {
    public DayOneStoreLevelDiscount() {
        this.minimumPurchase = 2000.0;
        this.discountAmount = 100.0;
    }
}
// DayTwoStoreLevelDiscount.java
public class DayTwoStoreLevelDiscount extends StoreLevelDiscount {
    public DayTwoStoreLevelDiscount() {
        this.minimumPurchase = 2500.0;
        this.discountAmount = 200.0;
    }
}
// Client.java
public class Client {
    public static void main( String[] args ) {
        performPayment(1000.0, "Regular Customer", new RegularCustomer("A", 1), new DayOneStoreLevelDiscount());
        performPayment(3000.0, "Regular Customer", new RegularCustomer("B", 3), new DayTwoStoreLevelDiscount());
        performPayment(1000.0, "Senior Citizen", new SeniorCitizen("A", 1), new DayOneStoreLevelDiscount());
        performPayment(3000.0, "Senior Citizen", new SeniorCitizen("B", 3), new DayTwoStoreLevelDiscount());
        performPayment(1000.0, "First Time Customer", new FirstTimeCustomer("A", 1), new DayOneStoreLevelDiscount());
        performPayment(3000.0, "First Time Customer", new FirstTimeCustomer("B", 3), new DayTwoStoreLevelDiscount());
    }

    public static void performPayment( double price, String customerType, Customer customer, StoreLevelDiscount storeLevelDiscount ) {
        price = storeLevelDiscount.applyDiscount(price);
        System.out.println( customerType + " discount = " + customer.getDiscount() + "%" );
        price = price * ( 1 - customer.getDiscount() / 100.0 );
        System.out.println( "Discount price = " + price );
    }
}
```

### 1. Adaptor (Structural)

#### Question

**Factory Method (Creational):** The ‘Decathlon POS’ software system classifies its 
customers as senior-citizens (60 and above), First-Time customers, Regular Customers. 
There is a very high possibility that the Customer Type hierarchy will vary, depending 
upon the sales-pattern. For e.g. there could be the need to introduce new categories 
based on the customer gender, different age groups for kids (0-5, 6-12), teenagers 
(13-19) and age groups between 20 to 60(Twenties, 30s, 40s and 50s). You are advised 
by Mr.Sundar Pichai, the technical architect of your team, whom you trust, to use 
Factory Method Pattern in order to instantiate the above Customer Type hierarchy 
of concrete implementation of objects. Design and implement using this.

#### Program

```java
// AgeCategory.java
public enum AgeCategory {
    kid("Kid"),
    teen("Teen"),
    adult("Adult"),
    senior("Senior");

    private final String text;
    AgeCategory( final String text ) { this.text = text; }
    @Override public String toString() { return text; }
}
// Customer.java
public abstract class Customer {
    protected String name;
    protected int age;
    protected AgeCategory category;

    public Customer( String name, int age ) {
        this.name = name;
        this.age = age;
    }

    public void details() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Category: " + category);
    }
}
// Kid.java
public class Kid extends Customer {
    public Kid( String name, int age ) {
        super( name, age );
        super.category = AgeCategory.kid;
    }
}
// Teen.java
public class Teen extends Customer {
    public Teen( String name, int age ) {
        super( name, age );
        super.category = AgeCategory.teen;
    }
}
// Adult.java
public class Adult extends Customer {
    public Adult( String name, int age ) {
        super( name, age );
        super.category = AgeCategory.adult;
    }
}
// Senior.java
public class Senior extends Customer {
    public Senior( String name, int age ) {
        super( name, age );
        super.category = AgeCategory.senior;
    }
}
// CustomerFactory.java
public class CustomerFactory {
    private static class InvalidAgeCategoryException extends Exception {
        public InvalidAgeCategoryException( String message ) {
            super(message);
        }
    }
    public static Customer get( AgeCategory ageCategory, String name, int age ) throws InvalidAgeCategoryException {
        switch( ageCategory ) {
            case kid: return new Kid( name, age );
            case teen: return new Teen( name, age );
            case adult: return new Adult( name, age );
            case senior: return new Senior( name, age );
            default: throw( new InvalidAgeCategoryException( "You have entered invalid age category" ) );
        }
    }
}
// Client.java
public class Client {
    public static void main( String[] args ) {
        try {
            CustomerFactory.get( AgeCategory.kid, "A", 1 ).details();
            CustomerFactory.get( AgeCategory.teen, "B", 13 ).details();
            CustomerFactory.get( AgeCategory.adult, "C", 18 ).details();
            CustomerFactory.get( AgeCategory.senior, "D", 61 ).details();
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
```

### 4. Bridge (Structural)

#### Question

**Bridge (Structural):** You get a call from Ms.Masaba Gupta of Bangalore Decathlon
office that there is a policy decision made globally to introduce discount slabs for a whole
month twice in a year. The discount month will be in January and July after reviewing the
sales made from Feb to June (first five months) and Aug to December (last five months)
respectively. It is decided to provide four slabs of discounts in 2017, namely, 30%, 25%,
20% and 15%, based on the sports item purchased. For e.g. all tennis rackets could have
a 20% discount while cricket bats could only have a 15% discount. All exercise tread-mills
could be given a 30% discount while boxing-gloves could have a 25% discount. Point to
be noted here is that, the slabs of discount may not remain the same in 2018. It is likely to
vary year after year. The ‘Decathlon POS’ software system classifies its customers as
Senior-Citizens (60 and above), First-Time Customers, Regular Customers as of now.
There is a very high possibility that the Customer Type hierarchy will vary, depending
upon the sales-pattern. For e.g. there could be the need to introduce new categories based
on the customer gender.
Use the Bridge Pattern to design & implement, so that both the Customer
Type hierarchy of classes as well as the Discount Percentage hierarchy of
classes can both vary independently? That is, they are not tied to each
other.

#### Program

```java
// DiscountCalculator.java
public abstract class DiscountCalculator {
    protected double discount;
    public double applyDiscount( double amount ) {
        return amount - amount * discount;
    }
}
// FirstDC.java
public class FirstDC extends DiscountCalculator {
    public FirstDC() {
        this.discount = 0.25;
    }
}
// SecondDC.java
public class SecondDC extends DiscountCalculator {
    public SecondDC() {
        this.discount = 0.30;
    }
}
// Customer.java
public abstract class Customer {
    protected String name;
    protected int age;
    protected DiscountCalculator discountCalculator;

    public void display() {
        System.out.println( "Name: " + this.name );
        System.out.println( "Age: " + this.age );
    }

    public void setDiscountCalculator( DiscountCalculator discountCalculator ) {
        this.discountCalculator = discountCalculator;
    }

    public double calculateBill( double amount ) {
        return this.discountCalculator.applyDiscount(amount);
    }
}
// RegularCustomer.java
public class RegularCustomer extends Customer {
    public RegularCustomer( String name, int age, DiscountCalculator discountCalculator ) {
        this.name = name;
        this.age = age;
        this.discountCalculator = discountCalculator;
    }

    @Override public void display() {
        System.out.println( "Welcome Regular Customer!" );
        super.display();
    }
}
// SeniorCitizen.java
public class SeniorCitizen extends Customer {
    public SeniorCitizen( String name, int age, DiscountCalculator discountCalculator ) {
        this.name = name;
        this.age = age;
        this.discountCalculator = discountCalculator;
    }

    @Override public void display() {
        System.out.println( "Welcome Senior Citizen!" );
        super.display();
    }
}
// FirstTimeCustomer.java
public class FirstTimeCustomer extends Customer {
    public FirstTimeCustomer( String name, int age, DiscountCalculator discountCalculator ) {
        this.name = name;
        this.age = age;
        this.discountCalculator = discountCalculator;
    }

    @Override public void display() {
        System.out.println( "Welcome First Time Customer!" );
        super.display();
    }
}
// Client.java
public class Client {
    public static void main( String[] args ) {
        FirstDC firstDC = new FirstDC();
        TestCustomer( new RegularCustomer( "A", 1, firstDC ) );
        TestCustomer( new FirstTimeCustomer( "B", 2, firstDC ) );
        TestCustomer( new SeniorCitizen( "C", 3, firstDC ) );
    }

    public static void TestCustomer( Customer customer ) {
        SecondDC secondDC = new SecondDC();
        customer.display();
        System.out.println( "1000 after discount using FirstDC: " + customer.calculateBill(1000) );
        customer.setDiscountCalculator(secondDC);
        System.out.println( "1000 after discount using SecondDC: " + customer.calculateBill(1000) );
    }
}
```

### 5. Observer (Behavioural)

#### Question

**Observer (Behavioural):** There will be different discounts being offered 
for the sports items in Decathlon Stores across the globe for different 
festivals being celebrated in the various countries these stores are 
established. Assume that the Decathlon Chain of Stores fixes a particular 
discount slab for its items for a festival of a country.
Use the Observer Pattern to design and implement a system to notify the 
customers of the Decathlon stores of that country about the various festival/
seasonal discount rates as and when they are announced.

#### Program

```java
// DiscountSlab.java
public class DiscountSlab {
    protected int discount;
    protected String festival;
    protected String start, end;

    public DiscountSlab( int discount, String festival, String start, String end ) {
        this.discount = discount;
        this.festival = festival;
        this.start = start;
        this.end = end;
    }
}
// DecathlonObserver.java
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
// DecathlonSubject.java
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
// Client.java
public class Client {
    private static void print( Object o ) {
        System.out.println( o );
    }
    public static void main( String[] args ) {
        DiscountSlab discount = new DiscountSlab( 10, "Diwali", "06-11-21", "09-11-21" );
        DecathlonSubject sale = new DecathlonSubject( discount );

        DecathlonObserver indiaCustomer = new DecathlonObserver(sale);
        DecathlonObserver sriLankaCustomer = new DecathlonObserver(sale);

        print( "-----------------DIWALI-----------------");
        print( "For Indian Customers: " );
        indiaCustomer.display();
        print( "For Sri Lankan Customers: " );
        sriLankaCustomer.display();

        discount = new DiscountSlab( 15, "Christmas", "24-12-21", "25-12-21" );
        sale.setDiscountSlab(discount);

        print( "---------------CHRISTMAS----------------");
        print( "For Indian Customers: " );
        indiaCustomer.display();
        print( "For Sri Lankan Customers: " );
        sriLankaCustomer.display();
    }
}
```

### 6. Façade (Structural)

#### Question

**Façade (Structural):** You get a call from Ms.Betty Cooper of Bangalore 
Decathlon office that there is a policy decision made globally to incorporate 
some new rules for ‘Process Sale Use-Case’. For e.g. if payment is made via 
gift-certificate, the customer can buy only one item for the amount in the 
certificate. No other items can be bought with that gift- certificate. There 
must be no cash-back to the customer if the item costs less than amount specified 
in the gift-certificate. If the item costs more, the excess payment can be 
accepted via cash only & not credit / debit cards. When a new sale is created, 
these rules must become effective. You come to know from Mr. Satya Nadella, an 
expert in finding 3rd- party partners, that the Italian Competitor for Decathlon 
called ‘Sport 2000’ has a ready- made ‘rule-engine’ sub-system for this, whose 
specific implementation details is not known yet, as the business heads of 
Decathlon & Sport 2000 are chalking out the software purchase terms. This Sport 
2000 rule-engine will be responsible for evaluating a set of rules against an 
operation & indicating if any of the rules invalidated the operation (e.g. 
‘makeNewSale’ operation).
How will you use the Façade pattern to provide a common unified 
interface to a dissimilar set of implementations, developed by a 3rd-party
vendor, the implementation details are not known to you?

#### Program

```java
// GiftCertificate.java
public class GiftCertificate {
    private String id;
    private int value;

    public GiftCertificate( String id, int value ) {
        this.id = id;
        this.value = value;
    }

    public String getID() { return id; }
    public int getValue() { return value; }
    public void setValue( int value ) { this.value = value; }
}
// ShoppingCart.java
import java.util.Scanner;
import java.util.ArrayList;

public class SalesFacade {
    private ShoppingCart cart;
    private ProcessSales processor;
    private Scanner sc;

    public SalesFacade() {
        cart = new ShoppingCart();
        processor = new ProcessSales(null, cart);
        sc = new Scanner( System.in );
    }

    private void print( Object o ) {
        System.out.println( o );
    }

    public void inputGiftCertificate() {
        print( "Enter GiftCertificate ID: " );
        String id = sc.next();
        print( "Enter GifrCertificate Value: " );
        int value = sc.nextInt();
        this.processor.certificate = new GiftCertificate( id, value );
    }

    public void inputItems() {
        ArrayList<ShoppingCart.Item> items;
        print( "Enter number of items: " );
        int size = sc.nextInt();
        items = new ArrayList<ShoppingCart.Item>(size);
        String _name;
        int _price;
        for( int i=0; i<size; i++ ) {
            print("Enter name of item " + (i+1) + ": ");
            _name = sc.next();
            print("Enter price of item " + (i+1) + ": ");
            _price = sc.nextInt();
            items.add(new ShoppingCart.Item(_name, _price));
        }
        processor.cart.items = items;
    }

    public void processSales() {
        processor.process();
    }
}
// ProcessSales.java
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
// SalesFacade.java 
import java.util.Scanner;
import java.util.ArrayList;

public class SalesFacade {
    private ShoppingCart cart;
    private ProcessSales processor;
    private Scanner sc;

    public SalesFacade() {
        cart = new ShoppingCart();
        processor = new ProcessSales(null, cart);
        sc = new Scanner( System.in );
    }

    private void print( Object o ) {
        System.out.println( o );
    }

    public void inputGiftCertificate() {
        print( "Enter GiftCertificate ID: " );
        String id = sc.next();
        print( "Enter GifrCertificate Value: " );
        int value = sc.nextInt();
        this.processor.certificate = new GiftCertificate( id, value );
    }

    public void inputItems() {
        ArrayList<ShoppingCart.Item> items;
        print( "Enter number of items: " );
        int size = sc.nextInt();
        items = new ArrayList<ShoppingCart.Item>(size);
        String _name;
        int _price;
        for( int i=0; i<size; i++ ) {
            print("Enter name of item " + (i+1) + ": ");
            _name = sc.next();
            print("Enter price of item " + (i+1) + ": ");
            _price = sc.nextInt();
            items.add(new ShoppingCart.Item(_name, _price));
        }
        processor.cart.items = items;
    }

    public void processSales() {
        processor.process();
    }
}
// Client.java
public class Client {
    public static void main(String[] args) {
        SalesFacade sales = new SalesFacade();
        sales.inputGiftCertificate();
        sales.inputItems();
        sales.processSales();
    }
}
```


### 7. Façade (Structural)

#### Question

**Abstract Factory (Creational):** As an analyst in charge of designing the 
Decathlon POS Software, you realize the need to streamline the creation of 
objects belonging to different products in the Decathlon store. There are 
two major categories of products:
a) For differently abled sports enthusiasts
b) For able-bodied sports enthusiasts
In each of the above categories there are products for outdoor adventure 
sports (e.g. trekking, para-gliding, bungee-jumping etc.), outdoor regular 
games (cricket, football, baseball etc.) indoor regular games (table tennis, 
squash etc.). There is a possibility of further class/object instantiation 
explosion with categories such as male & female sports enthusiasts and 
different equipment for them. Objects need to be instantiated based on 
these categories. Design & implement using Abstract Factory.

#### Program

```java
public enum IR {
    squash;
}
public enum OA {
    trekking;
}
public enum OR {
    cricket;
}
public interface IndoorRegular {
    public void display();
}
public interface OutdoorAdventure {
    public void display();
}
public interface OutdoorRegular {
    public void display();
}
public interface SportFactory {
    public OutdoorAdventure outdoorAdventure( OA oa );
    public OutdoorRegular outdoorRegular( OR or );
    public IndoorRegular indoorRegular( IR ir );
}
public class CricketA implements OutdoorRegular {
    public void display() {
        System.out.println("Cricket for able bodied");
    }
}
public class CricketD implements OutdoorRegular {
    public void display() {
        System.out.println("Cricket for differently able bodied");
    }
}
public class SquashA implements IndoorRegular {
    public void display() {
        System.out.println("Squash for able bodied");
    }
}
public class SquashD implements IndoorRegular {
    public void display() {
        System.out.println("Squash for differently able bodied");
    }
}
public class TrekkingA implements OutdoorAdventure {
    public void display() {
        System.out.println("Trekking for able bodied");
    }
}
public class TrekkingD implements OutdoorAdventure {
    public void display() {
        System.out.println("Trekking for differently able bodied");
    }
}
public class AbleFactory implements SportFactory {
    public OutdoorAdventure outdoorAdventure( OA oa ) {
        switch( oa ) {
            case trekking: return new TrekkingA();
            default: return null;
        }
    }
    public OutdoorRegular outdoorRegular( OR or ) {
        switch( or ) {
            case cricket: return new CricketA();
            default: return null;
        }
    }
    public IndoorRegular indoorRegular( IR ir ) {
        switch( ir ) {
            case squash: return new SquashA();
            default: return null;
        }
    }
}
public class DifferentlyAbleFactory implements SportFactory {
    public OutdoorAdventure outdoorAdventure( OA oa ) {
        switch( oa ) {
            case trekking: return new TrekkingD();
            default: return null;
        }
    }
    public OutdoorRegular outdoorRegular( OR or ) {
        switch( or ) {
            case cricket: return new CricketD();
            default: return null;
        }
    }
    public IndoorRegular indoorRegular( IR ir ) {
        switch( ir ) {
            case squash: return new SquashD();
            default: return null;
        }
    }
}
public class Client {
    public static void main( String[] args ) {
        SportFactory f = new AbleFactory();
        f.outdoorAdventure(OA.trekking).display();
        f.outdoorRegular(OR.cricket).display();
        f.indoorRegular(IR.squash).display();
        f = new DifferentlyAbleFactory();
        f.outdoorAdventure(OA.trekking).display();
        f.outdoorRegular(OR.cricket).display();
        f.indoorRegular(IR.squash).display();
    }
}
```
