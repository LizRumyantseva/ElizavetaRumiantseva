package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DivideDataProvider {

    @DataProvider(name = "Divide Data Provider")
    public Object[][] divideTestDataProvider() {
        return new Object[][]{
                {6, -2.5, -2.4},
                {-100, -20.6, 4.8543},
                {-12, 3, -4},
                {6, -2.5, -2.4},
                {0, -1, 0}
        };
    }
}
