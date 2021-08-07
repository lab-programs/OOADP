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