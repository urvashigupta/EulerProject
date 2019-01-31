/**
 * Project Euler
 * Problem 10: Prime Summation
 * Details in README
 *
 * @author  Urvashi Gupta
 * @since   2019-01-31
 */

public class PrimeSummation {

    /**
     * Algorithm inspired from Sieve of Eratosthenes
     * Boolean array indicates whether number is prime
     *
     * @param num The number below which we need to find primes
     * @return Sum of all primes
     */
    public static long getSumOfPrimes(int num) {
        boolean[] prime = new boolean[num + 1];

        PrimeHelper.initializePrimes(num, prime);
        PrimeHelper.updatePrimeMultiples(num, prime);
        return calculateSum(num, prime);
    }

    // Calculate sum
    private static long calculateSum(int num, boolean[] prime) {
        long sum = 0;
        for(int i = 2; i <= num; i++) {
            if(prime[i]) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        long sum = getSumOfPrimes(n);
        long end = System.currentTimeMillis();
        long time = end - start;

        System.out.println("The sum of prime numbers below "+ n + " is: " + sum);
        System.out.println("The time it took to run this program is: " + time + " ms");
    }
}
