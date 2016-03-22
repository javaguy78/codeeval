package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 21 : Sum integers
 * Created by cschalk on 3/21/16.
 */
public class Challenge21 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            sumTheDigits(line);
        }
    }

    private static void sumTheDigits(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            int digit = Integer.parseInt("" + c);
            sum += digit;
        }
        System.out.println(sum);
    }

}
