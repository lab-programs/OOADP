public class DifferentlyAbleFactory implements SportFactory {
    public OutdoorAdventure outdoorAdventure( OA oa ) {
        switch( oa ) {
            case trekking: return new TrekkingD();
            default: return null;
        }
    }
    public OutdoorRegular outdoorRegular( OR or ) {
        switch( or ) {
            case cricket: return new CricketD();
            default: return null;
        }
    }
    public IndoorRegular indoorRegular( IR ir ) {
        switch( ir ) {
            case squash: return new SquashD();
            default: return null;
        }
    }
}
