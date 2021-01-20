package hw5.Services.Pages.Components.Items.items;

import java.util.ArrayList;
import java.util.List;

public enum ServiceOptions {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex table"),
    SIMPLE_TABLE("Simple table"),
    USER_TABLE("User table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    private String name;
    ServiceOptions(String name) {
        this.name = name;
    }

    public String getOptionTitle() {
        return name;
    }

//    public static List<String> optionsAsList() {
//        List<String> result = new ArrayList<>();
//        for(ServiceOptions option : ServiceOptions.values()) {
//            result.add(option.getOptionTitle().toLowerCase());
//        }
//        return result;
//    }
}
