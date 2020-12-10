package hw1.testclasses;

import hw1.dataproviders.MultiplyDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest extends  AbstractCalculatorTest{

    @Test(dataProvider = "Multiply Data Provider",
            dataProviderClass = MultiplyDataProvider.class)
    public void multiplyTest(long a, long b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
}
