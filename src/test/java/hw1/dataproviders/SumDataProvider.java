package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class SumDataProvider {

    @DataProvider(name = "Sum Data Provider")
    public Object[][] sumTestDataProvider() {
        return new Object[][]{
                {1.52, 2, 3.52},
                {4, -1, 3},
                {0, 0, 0},
                {0, -1.33, -1.33},
                {-5, -6, -11}
        };
    }

}

