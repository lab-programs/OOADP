public class Client {
    private static void print( Object o ) {
        System.out.println( o );
    }
    public static void main( String[] args ) {
        TestDecorator(new GamesOnTable("table tennis"));
        TestDecorator(new BoardGames("chess"));
        TestDecorator(new CourtGames("basketball"));
        TestDecorator(new AdventureGames("trekking"));
        TestDecorator(new StadiumGames("cricket"));
        TestDecorator(new Athletics("100m sprint"));
    }
    private static void TestDecorator( DecathlonPOS decorator ) {
        print( decorator.getCurrentStock() );
    }
}
