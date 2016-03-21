package code.eval.moderate.challenge_46;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Challenge 46: Primes less than X
public class Main {

    static File inputFile;

    public static void main(String[] args) {
        getInputFile(args[0]);
        doWork();
    }

    private static void getInputFile(String fileName) {
        inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.err.println("Please specify a valid file name");
            System.exit(1);
        }
    }

    private static void doWork() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String bitInput;
            while ((bitInput = in.readLine()) != null) {
                listPrimesLessThan(bitInput);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
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
