public class AbleFactory implements SportFactory {
    public OutdoorAdventure outdoorAdventure( OA oa ) {
        switch( oa ) {
            case trekking: return new TrekkingA();
            default: return null;
        }
    }
    public OutdoorRegular outdoorRegular( OR or ) {
        switch( or ) {
            case cricket: return new CricketA();
            default: return null;
        }
    }
    public IndoorRegular indoorRegular( IR ir ) {
        switch( ir ) {
            case squash: return new SquashA();
            default: return null;
        }
    }
}
