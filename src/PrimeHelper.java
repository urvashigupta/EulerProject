public class PrimeHelper {

    /*
     * Initialize all numbers as prime
     * Boolean array values should be true
     * */
    public static void initializePrimes(int num, boolean[] prime) {
        for(int i = 0; i < num; i++) {
            prime[i] = true;
        }
    }

    /*
     * Set all multiples of a prime to false
     * Iterate only until the square root of num
     * */
    public static void updatePrimeMultiples(int num, boolean[] prime) {
        for(int i = 2;  i*i <= num; i++) {
            if(prime[i]) {
                // update all multiples of i
                int j = i*i;
                while(j <= num) {
                    prime[j] = false;
                    j += i;
                }
            }
        }
    }

}
