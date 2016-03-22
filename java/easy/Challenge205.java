package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 205 : Clean up words
 * Created by cschalk on 3/21/16.
 */
public class Challenge205 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
           cleanLine(line);
        }
    }

    private static boolean lastLetter = false;

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
