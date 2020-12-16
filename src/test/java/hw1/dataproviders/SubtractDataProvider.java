package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class SubtractDataProvider {

    @DataProvider(name = "Subtract Data Provider")
    public Object[][] subtractTestDataProvider() {
        return new Object[][]{
                {1, 2, -1},
                {0, -11, 11},
                {-23, -10, -13},
                {0, 0, 0},
                {-2, 10, -12},
        };
    }

}
