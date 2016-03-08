package code.eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Clean Up The Words
public class Challenge205 {

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
            String toClean;
            while ((toClean = in.readLine()) != null) {
                cleanLine(toClean);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    static boolean lastLetter = false;

    private static void cleanLine(String line) {
        StringBuilder toPrint = new StringBuilder();
        for (char c : line.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                toPrint.append(c);
                lastLetter = true;
            } else {
                if (lastLetter) {
                    toPrint.append(" ");
                    lastLetter = false;
                }
            }
        }

        System.out.println(toPrint.toString().trim());
    }

}
