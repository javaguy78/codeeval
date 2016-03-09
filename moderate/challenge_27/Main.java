package code.eval.medium.challenge_27;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Challenge 27: Decimal to Binary
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
                decimalToBinary(bitInput);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void decimalToBinary(String input) {
        String binary = Integer.toBinaryString(Integer.parseInt(input));
        System.out.println(binary);
    }
}
