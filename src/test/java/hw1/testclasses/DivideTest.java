package hw1.testclasses;

import hw1.dataproviders.DivideDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest extends  AbstractCalculatorTest{

    @Test(dataProvider = "Divide Data Provider",
            dataProviderClass = DivideDataProvider.class)
    public void divideTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.0001);
    }
}
