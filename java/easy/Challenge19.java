package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 19 : Bit Positions
 * Created by cschalk on 3/21/16.
 */
public class Challenge19 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            bitPositions(line);
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
