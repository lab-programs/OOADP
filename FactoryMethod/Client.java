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