package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class PowDataProvider {
    @DataProvider(name = "Pow Data Provider")
    public Object[][] powTestDataProvider() {
        return new Object[][]{
                {1, 10, 1},
                {2, -2, 0.25},
                {10, 0, 1},
                {-10, 2, 100},
                {0, 10, 0},
                {2, 1, 2},
                {-5, -3, -0.008}
        };
    }
}
