import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistinctPowersTest {

    @Test
    void testIncorrectInputs() {
        Assertions.assertEquals(-1, DistinctPowers.getDistinctPowers(5, 2));
    }

    @Test
    void testInputsForTwoAndFive() {
        Assertions.assertEquals(15, DistinctPowers.getDistinctPowers(2, 5));
    }

    @Test
    void testInputsForTwoAndHundred() {
        Assertions.assertEquals(9183, DistinctPowers.getDistinctPowers(2, 100));
    }
}