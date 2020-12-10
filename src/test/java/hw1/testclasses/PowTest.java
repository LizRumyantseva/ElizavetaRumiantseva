package hw1.testclasses;

import hw1.dataproviders.PowDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PowTest extends AbstractCalculatorTest {

    @Test(dataProvider = "Pow Data Provider",
            dataProviderClass = PowDataProvider.class)
    public void powTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        assertEquals(actual, expected);
    }
}
