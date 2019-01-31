public class PrimeSummationUnOptimized {

    // Returns sum of primes in range from 1 to n.
    public static long getSumOfPrimes(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i=2; i<n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 80000; // increasing to 2000000 decreases the performance significantly
        long start = System.currentTimeMillis();
        long sum = getSumOfPrimes(n);
        long end = System.currentTimeMillis();
        long time = end - start;

        System.out.println("The sum of prime numbers below "+ n + " are: " + sum);
        System.out.println("The time it took to run this program is: " + time + " ms");
    }
}
