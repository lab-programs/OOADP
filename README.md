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
// CalcTax.java
public interface CalcTax {
	double taxAmount(String item, int qty, double price);
}
// NewMauritiusTax.java
public class NewMauritiusTax {
	double calcTax(int qntty, double price) {
		return price*qntty*(0.25f);
	}
}
// MyMauritiusTax.java
public class MyMauritiusTax implements CalcTax {
	NewMauritiusTax mt = new NewMauritiusTax();
	double tax_amount=0.0;
	@Override
	public double taxAmount(String item, int qty, double price) {
		tax_amount = mt.calcTax(qty, price);
		return tax_amount;
	}
}
// SwedenTax.java
public class SwedenTax implements CalcTax {
	double tax_amount=0.0;
	public double taxAmount(String item, int qty, double price) {
		tax_amount = price*qty*0.05f;
		return tax_amount;
	}
}
// Item.java
public class Item {
	String name;
	double price=0.0;
	int qty=0;
	double billAmount=0.0;
	CalcTax ct;
	Item(String name, double price, CalcTax ct){
		this.name = name;
		this.price = price;
		this.ct = ct;
	}
	void setTax(CalcTax ct) {
		this.ct = ct;
	}
	void setQunatity(int qty) {
		this.qty = qty;
	}
	void printPrice() {
		double tax = ct.taxAmount(name, qty, price);
		
		billAmount = price*qty+tax;
		System.out.println("Tax = "+tax);
		System.out.println("Item "+ name + " Quantity "+qty+
		" Unit price "+price+ " Total Amount "+billAmount);
	}
}
// TaxAdapterDemo.java
public class TaxAdapterDemo {
	public static void main(String[] args) {
		SwedenTax st = new SwedenTax();
		Item i1 = new Item("Btwin Roackroder 340", 13999.0, st);
		i1.setQunatity(3);
		i1.printPrice();
		i1.setTax(new MyMauritiusTax());
		i1.printPrice();
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
// iDiscountCalculator.java
public interface iDiscountCalculator {
	public void calculateBillAmount(double mrptotal); 
}
// DecathlonCustomer.java
abstract class DecathlonCustomer {
	static String name; 
	static int age;
	iDiscountCalculator iCC; 
	DecathlonCustomer(){}
	public void calculateDiscount(double mrptotal) { 
		iCC.calculateBillAmount(mrptotal); 
	}
	public void display() { 
		System.out.println("Name is "+ name + " \nAge is " + age); 
	}
}
// NewMauritiusTax.java
public class NewMauritiusTax {
	double calcTax(int qntty, double price) {
		return price*qntty*(0.25f);
	}
}
// MyMauritiusTax.java
public class MyMauritiusTax implements CalcTax {
	NewMauritiusTax mt = new NewMauritiusTax();
	double tax_amount=0.0;
	@Override
	public double taxAmount(String item, int qty, double price) {
		tax_amount = mt.calcTax(qty, price);
		return tax_amount;
	}
}
// SwedenTax.java
public class SwedenTax implements CalcTax {
	double tax_amount=0.0;
	public double taxAmount(String item, int qty, double price) {
		tax_amount = price*qty*0.05f;
		return tax_amount;
	}
}
// Item.java
public class Item {
	String name;
	double price=0.0;
	int qty=0;
	double billAmount=0.0;
	CalcTax ct;
	Item(String name, double price, CalcTax ct){
		this.name = name;
		this.price = price;
		this.ct = ct;
	}
	void setTax(CalcTax ct) {
		this.ct = ct;
	}
	void setQunatity(int qty) {
		this.qty = qty;
	}
	void printPrice() {
		double tax = ct.taxAmount(name, qty, price);
		
		billAmount = price*qty+tax;
		System.out.println("Tax = "+tax);
		System.out.println("Item "+ name + " Quantity "+qty+
		" Unit price "+price+ " Total Amount "+billAmount);
	}
}
// TaxAdapterDemo.java
public class TaxAdapterDemo {
	public static void main(String[] args) {
		SwedenTax st = new SwedenTax();
		Item i1 = new Item("Btwin Roackroder 340", 13999.0, st);
		i1.setQunatity(3);
		i1.printPrice();
		i1.setTax(new MyMauritiusTax());
		i1.printPrice();
	}
}
```

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
// CalcTax.java
public interface CalcTax {
	double taxAmount(String item, int qty, double price);
}
// NewMauritiusTax.java
public class NewMauritiusTax {
	double calcTax(int qntty, double price) {
		return price*qntty*(0.25f);
	}
}
// MyMauritiusTax.java
public class MyMauritiusTax implements CalcTax {
	NewMauritiusTax mt = new NewMauritiusTax();
	double tax_amount=0.0;
	@Override
	public double taxAmount(String item, int qty, double price) {
		tax_amount = mt.calcTax(qty, price);
		return tax_amount;
	}
}
// SwedenTax.java
public class SwedenTax implements CalcTax {
	double tax_amount=0.0;
	public double taxAmount(String item, int qty, double price) {
		tax_amount = price*qty*0.05f;
		return tax_amount;
	}
}
// Item.java
public class Item {
	String name;
	double price=0.0;
	int qty=0;
	double billAmount=0.0;
	CalcTax ct;
	Item(String name, double price, CalcTax ct){
		this.name = name;
		this.price = price;
		this.ct = ct;
	}
	void setTax(CalcTax ct) {
		this.ct = ct;
	}
	void setQunatity(int qty) {
		this.qty = qty;
	}
	void printPrice() {
		double tax = ct.taxAmount(name, qty, price);
		
		billAmount = price*qty+tax;
		System.out.println("Tax = "+tax);
		System.out.println("Item "+ name + " Quantity "+qty+
		" Unit price "+price+ " Total Amount "+billAmount);
	}
}
// TaxAdapterDemo.java
public class TaxAdapterDemo {
	public static void main(String[] args) {
		SwedenTax st = new SwedenTax();
		Item i1 = new Item("Btwin Roackroder 340", 13999.0, st);
		i1.setQunatity(3);
		i1.printPrice();
		i1.setTax(new MyMauritiusTax());
		i1.printPrice();
	}
}
```

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
// CalcTax.java
public interface CalcTax {
	double taxAmount(String item, int qty, double price);
}
// NewMauritiusTax.java
public class NewMauritiusTax {
	double calcTax(int qntty, double price) {
		return price*qntty*(0.25f);
	}
}
// MyMauritiusTax.java
public class MyMauritiusTax implements CalcTax {
	NewMauritiusTax mt = new NewMauritiusTax();
	double tax_amount=0.0;
	@Override
	public double taxAmount(String item, int qty, double price) {
		tax_amount = mt.calcTax(qty, price);
		return tax_amount;
	}
}
// SwedenTax.java
public class SwedenTax implements CalcTax {
	double tax_amount=0.0;
	public double taxAmount(String item, int qty, double price) {
		tax_amount = price*qty*0.05f;
		return tax_amount;
	}
}
// Item.java
public class Item {
	String name;
	double price=0.0;
	int qty=0;
	double billAmount=0.0;
	CalcTax ct;
	Item(String name, double price, CalcTax ct){
		this.name = name;
		this.price = price;
		this.ct = ct;
	}
	void setTax(CalcTax ct) {
		this.ct = ct;
	}
	void setQunatity(int qty) {
		this.qty = qty;
	}
	void printPrice() {
		double tax = ct.taxAmount(name, qty, price);
		
		billAmount = price*qty+tax;
		System.out.println("Tax = "+tax);
		System.out.println("Item "+ name + " Quantity "+qty+
		" Unit price "+price+ " Total Amount "+billAmount);
	}
}
// TaxAdapterDemo.java
public class TaxAdapterDemo {
	public static void main(String[] args) {
		SwedenTax st = new SwedenTax();
		Item i1 = new Item("Btwin Roackroder 340", 13999.0, st);
		i1.setQunatity(3);
		i1.printPrice();
		i1.setTax(new MyMauritiusTax());
		i1.printPrice();
	}
}
```

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
// CalcTax.java
public interface CalcTax {
	double taxAmount(String item, int qty, double price);
}
// NewMauritiusTax.java
public class NewMauritiusTax {
	double calcTax(int qntty, double price) {
		return price*qntty*(0.25f);
	}
}
// MyMauritiusTax.java
public class MyMauritiusTax implements CalcTax {
	NewMauritiusTax mt = new NewMauritiusTax();
	double tax_amount=0.0;
	@Override
	public double taxAmount(String item, int qty, double price) {
		tax_amount = mt.calcTax(qty, price);
		return tax_amount;
	}
}
// SwedenTax.java
public class SwedenTax implements CalcTax {
	double tax_amount=0.0;
	public double taxAmount(String item, int qty, double price) {
		tax_amount = price*qty*0.05f;
		return tax_amount;
	}
}
// Item.java
public class Item {
	String name;
	double price=0.0;
	int qty=0;
	double billAmount=0.0;
	CalcTax ct;
	Item(String name, double price, CalcTax ct){
		this.name = name;
		this.price = price;
		this.ct = ct;
	}
	void setTax(CalcTax ct) {
		this.ct = ct;
	}
	void setQunatity(int qty) {
		this.qty = qty;
	}
	void printPrice() {
		double tax = ct.taxAmount(name, qty, price);
		
		billAmount = price*qty+tax;
		System.out.println("Tax = "+tax);
		System.out.println("Item "+ name + " Quantity "+qty+
		" Unit price "+price+ " Total Amount "+billAmount);
	}
}
// TaxAdapterDemo.java
public class TaxAdapterDemo {
	public static void main(String[] args) {
		SwedenTax st = new SwedenTax();
		Item i1 = new Item("Btwin Roackroder 340", 13999.0, st);
		i1.setQunatity(3);
		i1.printPrice();
		i1.setTax(new MyMauritiusTax());
		i1.printPrice();
	}
}
```
