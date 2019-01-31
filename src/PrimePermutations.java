import java.util.*;

/**
 * Project Euler
 * Problem 49: Prime Permutation
 * Details in README
 *
 * @author  Urvashi Gupta
 * @since   2019-01-31
 */

public class PrimePermutations {

    private static final int MAX_NUMBER = 9999; // since we only need 4 digit permutations
    private static final int MIN_START_PERMUTATION = 1488; // since 1487 is already a known prime permute
    private static final int MAX_ARRAY_SIZE = 4; // since we are only finding 4 digit numbers
    private static long result = 0;


    /**
     * Parent function to calculate permutation difference
     * of all 4-digit prime numbers and find result
     */
    private static void calculatePrimePermutation() {

        // generate all 4 digit prime numbers
        HashSet<Integer> primeNumbers = getFourDigitPrimes();

        // iterate over prime numbers
        // find permutations and calculate difference
        for(int n : primeNumbers) {

            // generate all prime permutations of the current number n
            ArrayList<Integer> validNumbers = checkPermutationsExist(primeNumbers, n);

            // find the difference between prime numbers and calculate result
            calculateResult(validNumbers);
        }
    }


    /*
     * Uses Sieve of Eratosthenes to calculate 4 digit primes
     * Calculate only from 1488 (MIN_START_PERMUTATION)
     * because 1487 is a known prime permutation
     *
     * This is exactly the same as Prime Summation
     * Difference is we change the lower and upper bound for primes
     * */
    private static HashSet<Integer> getFourDigitPrimes() {
        int num = MAX_NUMBER;
        boolean[] prime = new boolean[num + 1];

        PrimeHelper.initializePrimes(num, prime);
        PrimeHelper.updatePrimeMultiples(num, prime);

        // add all four digit numbers to a set.
        HashSet<Integer> numbers = new HashSet<>();
        for(int i = MIN_START_PERMUTATION; i < num; i++) {
            if(prime[i]){
                numbers.add(i);
            }
        }
        return numbers;
    }


    /**
     * Generate all permutations of current number
     * And check if its a valid prime number
     *
     * @param primeNumbers Set of all 4 digit prime numbers
     * @param num the actual number
     * @return list of 4 digit numbers which are permuted primes
     */
    private static ArrayList<Integer> checkPermutationsExist(HashSet<Integer> primeNumbers, int num) {
        // add the number to an array for generating permutations
        int[] arr = getNumber(num);
        List<List<Integer>> permutations = findPermutations(arr);

        ArrayList<Integer> validNumbers = new ArrayList<>();
        validNumbers.add(num);

        for(List<Integer> number : permutations) {
            int numFormed = 0;
            for(int i : number) {
                numFormed = numFormed * 10 + i;
            }
            if(primeNumbers.contains(numFormed) && numFormed != num) {
                validNumbers.add(numFormed);
            }
        }
        return validNumbers;
    }


    /*
     * Adds a number to an array
     * 1431 --> [1, 4, 3, 1]
     * */
    private static int[] getNumber(int num) {
        int[] arr = new int[MAX_ARRAY_SIZE];
        int index = arr.length - 1;

        while(num != 0) {
            arr[index--] = num % 10;
            num = num / 10;
        }
        return arr;
    }


    /**
     * Generate all permutations of current number
     *
     * @param nums digits of the number
     * @return list of all permutations
     */
    private static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    /**
     * Backtracking function which recursively calculates permutations
     *
     * @param list result list
     * @param tempList temporary list to add the digits
     * @param nums digits of the current number
     * @param visited boolean array to indicate if a number is already visited
     */
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] visited){
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                // this condition avoids creating duplicate permutations
                if(visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i - 1])
                    continue;

                visited[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, visited);
                visited[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    /**
     * Checks the difference between all prime permutations
     * If the differences match, then result is calculated
     *
     * @param validNumbers Set of all valid 4 digit prime permutations
     */
    private static void calculateResult(ArrayList<Integer> validNumbers) {
        if(validNumbers.size() >= 3 ) {
            Collections.sort(validNumbers);

            for(int i=0; i<validNumbers.size(); i++) {
                for(int j=i+1; j<validNumbers.size(); j++) {
                    for(int k=j+1; k<validNumbers.size(); k++) {

                        int diff1 = validNumbers.get(j) - validNumbers.get(i);
                        int diff2 = validNumbers.get(k) - validNumbers.get(j);
                        if (diff1 == diff2) {
                            // found the result -- concatenate it
                            StringBuilder sb = new StringBuilder();
                            sb.append(validNumbers.get(i));
                            sb.append(validNumbers.get(j));
                            sb.append(validNumbers.get(k));
                            result = Long.parseLong(sb.toString());
                            // we can also add a break here
                            // since we know there is only one solution
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        calculatePrimePermutation();
        long end = System.currentTimeMillis();
        long time = end - start;

        System.out.println("The 4 digit prime permutation is: " + result);
        System.out.println("The time it took to run this program is: " + time + " ms");
    }
}
