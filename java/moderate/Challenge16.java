package code.eval.moderate.challenge_16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Challenge 16: Number of Ones
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
            String input;
            while ((input = in.readLine()) != null) {
                numberOfOnes(input);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void numberOfOnes(String input) {
        String binary = Integer.toBinaryString(Integer.parseInt(input));
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        System.out.println(count);
    }

}
