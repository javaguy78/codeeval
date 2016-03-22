package easy;

/**
 * Challenge 04 : Sum first 1000 primes
 * Created by cschalk on 3/21/16.
 */
public class Challenge04 {

    private static int totalSum = 0;
    private static int primesFound = 0;

    public static void main(String[] args) {
        int test = 1;
        do {
            if (isPrime(test)) {
                totalSum += test;
                primesFound++;
            }
            test++;
        } while (primesFound < 1000);
        System.out.println(totalSum);
        System.exit(1);
    }

    private static boolean isPrime(int in) {
        if (in <= 1) { return false; }
        if (in == 2) { return true; }
        for (int i = 2 ; i < Math.sqrt(in) + 1 ; i++ ) {
            if (in % i == 0) { return false; }
        }
        return true;
    }

}
