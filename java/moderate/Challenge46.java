package moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 46 : Primes less than X
 * Created by cschalk on 3/21/16.
 */
public class Challenge46 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            listPrimesLessThan(line);
        }
    }

    private static void listPrimesLessThan(String input) {
        Long limit = Long.parseLong(input);
        StringBuilder primeList = new StringBuilder();
        if (limit > 2) {
            primeList.append("2");
        }
        for (long i = 3 ; i < limit ; i+=2) {
            if (isPrime(i)) {
                if (primeList.length() > 0) {
                    primeList.append(",");
                }
                primeList.append(i);
            }
        }

        System.out.println(primeList.toString());
    }

    private static boolean isPrime(long input) {
        if (input <= 1) { return false; }
        if (input == 2) { return true; }
        for (long i = 2 ; i < Math.sqrt(input) + 1 ; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}
