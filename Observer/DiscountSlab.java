public class DiscountSlab {
    protected int discount;
    protected String festival;
    protected String start, end;

    public DiscountSlab( int discount, String festival, String start, String end ) {
        this.discount = discount;
        this.festival = festival;
        this.start = start;
        this.end = end;
    }
}