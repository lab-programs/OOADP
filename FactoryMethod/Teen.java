public class Teen extends Customer {
    public Teen( String name, int age ) {
        super( name, age );
        super.category = AgeCategory.teen;
    }
}