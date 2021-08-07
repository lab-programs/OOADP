public class Adult extends Customer {
    public Adult( String name, int age ) {
        super( name, age );
        super.category = AgeCategory.adult;
    }
}