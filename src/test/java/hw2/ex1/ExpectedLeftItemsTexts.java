package hw2.ex1;

public enum ExpectedLeftItemsTexts {
    FIRST("Home"),

    SECOND("Contact form"),

    THIRD("Service"),

    FORTH("Metals & Colors"),

    FIFTH("Elements packs");

    private String text;

    ExpectedLeftItemsTexts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
