public abstract class IndoorDecorator implements DecathlonPOS {
    protected String game;
    protected DecathlonPOS type;

    public IndoorDecorator( String game ) {
        this.game = game;
        this.type = new IndoorSports();
    }

    @Override public String getCurrentStock() {
        return this.type.getCurrentStock() + ": " + this.game;
    }
}
