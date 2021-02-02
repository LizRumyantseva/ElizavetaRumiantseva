package hw6.enums;

public enum ResultData {
    ELEMENTS("Elements"),
    VEGETABLES("Vegetables"),
    COLOR("Color"),
    METAL("Metal"),
    SUMMARY("Summary");

    private String value;

    ResultData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
