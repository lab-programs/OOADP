public enum AgeCategory {
    kid("Kid"),
    teen("Teen"),
    adult("Adult"),
    senior("Senior");

    private final String text;
    AgeCategory( final String text ) { this.text = text; }
    @Override public String toString() { return text; }
}