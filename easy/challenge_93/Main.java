package code.eval.easy.challenge_93;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Challenge 93: Capitalize Strings
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
                capitalizeString(inString);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void capitalizeString(String input) {
        String[] words = input.split(" ");
        String output = "";
        for (String word : words) {
            output += capitalize(word).concat(" ");
        }
        System.out.println(output.trim());
    }

    private static String capitalize(String word) {
        String toReturn = ("" + word.charAt(0)).toUpperCase();
        return toReturn + word.substring(1);
    }
}
