package code.eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Nth Fibonacci Element
public class Challenge22 {

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
                nthFib(bitInput);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void nthFib(String input) {
        if (input != null && !input.isEmpty()) {
            int digit = Integer.parseInt(input);
            if (digit == 0) System.out.println(0);
            else if (digit == 1 || digit == 2) System.out.println(1);
            else {
                int a1 = 1, a2 = 1, tmp = 0;
                for (int i = 3; i <= digit; i++) {
                    tmp = a1 + a2;
                    a1 = a2;
                    a2 = tmp;
                }
                System.out.println(tmp);
            }
        }
    }
}
