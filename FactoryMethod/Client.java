public class Client {
    public static void main( String[] args ) {
        private class A extends Customer {
            A( String name, int age ) {
                super( name, age );
                super.category = AgeCategory.kid;
            }
        }
        A a = new A();
        a.details();
    }
}