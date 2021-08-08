public class Client {
    public static void main( String[] args ) {
        SportFactory f = new AbleFactory();
        f.outdoorAdventure(OA.trekking).display();
        f.outdoorRegular(OR.cricket).display();
        f.indoorRegular(IR.squash).display();
        f = new DifferentlyAbleFactory();
        f.outdoorAdventure(OA.trekking).display();
        f.outdoorRegular(OR.cricket).display();
        f.indoorRegular(IR.squash).display();
    }
}
