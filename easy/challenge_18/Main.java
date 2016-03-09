package code.eval.easy.challenge_18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Challenge 18: Multiples of a Number
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
            String combo;
            while ((combo = in.readLine()) != null) {
                evalCombo(combo);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    static int multiple = 0;

    private static void evalCombo(String combo) {
        int x = Integer.parseInt(combo.split(",")[0]);
        int n = multiple = Integer.parseInt(combo.split(",")[1]);
        checkNGreaterThanX(x, n);
    }

    private static void checkNGreaterThanX(int x, int n) {
        if (n > x) {
            System.out.println(n);
        } else {
            checkNGreaterThanX(x, n + multiple);
        }
    }
}
