public abstract class OutdoorDecorator implements DecathlonPOS {
    protected String game;
    protected DecathlonPOS type;

    public OutdoorDecorator( String game ) {
        this.game = game;
        this.type = new OutdoorSports();
    }

    @Override public String getCurrentStock() {
        return this.type.getCurrentStock() + ": " + this.game;
    }
}
