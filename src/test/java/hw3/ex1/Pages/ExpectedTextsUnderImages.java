package hw3.ex1.Pages;

public enum ExpectedTextsUnderImages {
    FIRST("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),

    SECOND("To be flexible and\n" +
            "customizable"),

    THIRD("To be multiplatform"),

    FORTH("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    private String text;

    ExpectedTextsUnderImages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
