import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeSummationTest {

    @Test
    void testSumOfPrimesInvalidInput() {
        Assertions.assertEquals(0, PrimeSummation.getSumOfPrimes(0));
        Assertions.assertEquals(0, PrimeSummation.getSumOfPrimes(-1));

    }

    @Test
    void testSumOfPrimesLessThan100() {
        Assertions.assertEquals(17, PrimeSummation.getSumOfPrimes(10));
        Assertions.assertEquals(1060, PrimeSummation.getSumOfPrimes(100));
    }

    @Test
    void testSumOfPrimesLessThanTwoMillion() {
        Assertions.assertEquals(142913828922L, PrimeSummation.getSumOfPrimes(2000000));
    }
}
