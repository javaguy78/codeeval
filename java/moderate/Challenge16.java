package moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 16 : Number of ones
 * Created by cschalk on 3/21/16.
 */
public class Challenge16 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            numberOfOnes(line);
        }
    }

    private static void numberOfOnes(String input) {
        String binary = Integer.toBinaryString(Integer.parseInt(input));
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
