public class Client {
    private static class A extends Customer {
        A( String name, int age ) {
            super( name, age );
            super.category = AgeCategory.kid;
        }
    }
    public static void main( String[] args ) {
        A a = new A("A", 1);
        a.details();
    }
}