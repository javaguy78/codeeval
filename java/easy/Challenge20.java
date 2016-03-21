package code.eval.easy.challenge_20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Challenge 20: Strings to Lower Case
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
            String inString;
            while ((inString = in.readLine()) != null) {
                System.out.println(inString.toLowerCase());
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }
}
