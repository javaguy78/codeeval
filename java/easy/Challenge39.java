package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Challenge 39 : Happy Numbers
 * Created by cschalk on 3/21/16.
 */
public class Challenge39 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            processHappyOrNot(line);
        }
    }

    private static ArrayList<Integer> seenList = new ArrayList<>();

    private static void processHappyOrNot(String input) {
        seenList = new ArrayList<>();
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
