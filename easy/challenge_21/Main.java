package code.eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Sum of specified integers
public class Challenge21 {
    
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
                sumTheDigits(input);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void sumTheDigits(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            int digit = Integer.parseInt("" + c);
            sum += digit;
        }
        System.out.println(sum);
    }

}
