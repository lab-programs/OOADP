public class Senior extends Customer {
    public Senior( String name, int age ) {
        super( name, age );
        super.category = AgeCategory.senior;
    }
}