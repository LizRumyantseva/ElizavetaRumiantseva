package hw1.testclasses;

import hw1.dataproviders.SubtractDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest extends AbstractCalculatorTest {

    @Test(dataProvider = "Subtract Data Provider",
            dataProviderClass = SubtractDataProvider.class)
    public void subtractTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

}
