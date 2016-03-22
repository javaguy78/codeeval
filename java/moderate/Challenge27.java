package moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 27 : Decimal to Binary
 * Created by cschalk on 3/21/16.
 */
public class Challenge27 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            decimalToBinary(line);
        }
    }

    private static void decimalToBinary(String input) {
        String binary = Integer.toBinaryString(Integer.parseInt(input));
        System.out.println(binary);
    }
}
