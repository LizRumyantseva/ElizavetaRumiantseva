package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class MultiplyDataProvider {

    @DataProvider(name = "Multiply Data Provider")
    public Object[][] multiplyTestDataProvider() {
        return new Object[][]{
                {1, -2, -2},
                {-5, 4, -20},
                {0, 1, 0},
                {-5, 0, 0},
                {3, 4, 12},
        };
    }
}
