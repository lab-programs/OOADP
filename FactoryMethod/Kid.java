public class Kid extends Customer {
    public Kid( String name, int age ) {
        super( name, age );
        super.category = AgeCategory.kid;
    }
}