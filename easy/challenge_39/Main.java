package code.eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Happy Numbers
public class Challenge39 {

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
                processHappyOrNot(bitInput);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    static ArrayList seenList = new ArrayList();

    private static void processHappyOrNot(String input) {
        seenList = new ArrayList();
        isHappyOrNot(Integer.parseInt(input));
    }

    private static void isHappyOrNot(int input) {
        if (input == 1) {
            System.out.println("1");
        } else if (weHaveSeenThisBefore(input)){
            System.out.println("0");
        } else {
            String strInput = "" + input;
            int next = 0;
            for (char c : strInput.toCharArray()) {
                int digit = Integer.parseInt("" + c);
                next += (digit * digit);
            }
            isHappyOrNot(next);
        }
    }

    private static boolean weHaveSeenThisBefore(int input) {
        if (seenList.indexOf(input) != -1) {
            return true;
        } else {
            seenList.add(input);
            return false;
        }
    }
}
