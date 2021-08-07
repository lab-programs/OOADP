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