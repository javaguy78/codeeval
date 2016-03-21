package code.eval.moderate.challenge_12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Challenge 12: First non-duplicate letter
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
                runChallenge(input);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void runChallenge(String input) {
        ArrayList<String> foundLetters = new ArrayList<>();
        ArrayList<String> foundDuplicates = new ArrayList<>();
        for (char c : input.toCharArray()) {
            String work = "" + c;
            if (!foundDuplicates.contains(work)) {
                if (!foundLetters.contains(work)) {
                    foundLetters.add(work);
                } else {
                    foundLetters.remove(work);
                    foundDuplicates.add(work);
                }
            }
        }
        if (foundLetters.size() > 0)
            System.out.println(foundLetters.get(0));
    }
}
