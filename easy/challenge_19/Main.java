package code.eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Bit Positions
public class Challenge19 {

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
                bitPositions(bitInput);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void bitPositions(String input) {
        int value = Integer.parseInt(input.split(",")[0]);
        int pos1  = Integer.parseInt(input.split(",")[1]);
        int pos2  = Integer.parseInt(input.split(",")[2]);

        String binaryValue = reverseString(Integer.toBinaryString(value));
        if (binaryValue.charAt(pos1 - 1) == binaryValue.charAt(pos2 - 1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static String reverseString(String input) {
        String toReturn = "";
        for (char c : input.toCharArray()) {
            toReturn = c + toReturn;
        }
        return toReturn;
    }
}
