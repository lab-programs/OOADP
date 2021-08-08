public class GiftCertificate {
    private String id;
    private int value;

    public GiftCertificate( String id, int value ) {
        this.id = id;
        this.value = value;
    }

    public String getID() { return id; }
    public int getValue() { return value; }
    public void setValue( int value ) { this.value = value; }
}