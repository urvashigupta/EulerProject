import java.util.HashSet;

/**
 * Project Euler
 * Problem 29: Distinct Powers
 * Details in README
 *
 * @author  Urvashi Gupta
 * @since   2019-01-31
 */

public class DistinctPowers {

    /**
     * Find all distinct powers
     * If inputs are incorrect, return -1
     *
     * @param low The lower bound for integer combinations of a^b
     * @param high The upper bound for integer combinations of a^b
     * @return size of the set which contains distinct powers
     */
    public static int getDistinctPowers(int low, int high) {
        if(low > high) return -1;

        // HashSet ensures lookup time to O(1)
        HashSet<Double> numbers = new HashSet<>();
        double result = 0;

        for(int a = low; a <= high; a++) {
            for(int b = low; b <= high; b++) {
                result = Math.pow(a, b);
                numbers.add(result);
            }
        }

        return numbers.size();
    }

    public static void main(String[] args) {
        int low = 2, high = 100;
        long start = System.currentTimeMillis();
        long terms = getDistinctPowers(low, high);
        long end = System.currentTimeMillis();
        long time = end - start;

        if(terms == -1) {
            System.out.println("Incorrect input");
        }
        else {
            System.out.println("Number of distinct powers between " + low + " and " + high + ": " + terms);
        }
        System.out.println("The time it took to run this program is: " + time + " ms");
    }
}
