package code.eval.easy.challenge_04;

// Challenge 4: Sum of first 1000 primes
public class Main {

    static int totalSum = 0;
    static int primesFound = 0;

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
