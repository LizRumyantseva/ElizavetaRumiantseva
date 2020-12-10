package hw1.testclasses;

import hw1.dataproviders.SumDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest extends AbstractCalculatorTest {

    @Test(dataProvider = "Sum Data Provider",
            dataProviderClass = SumDataProvider.class)
    public void sumTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
}
