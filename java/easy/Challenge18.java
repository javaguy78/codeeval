package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 18 : Multiples of a Number
 * Created by cschalk on 3/21/16.
 */
public class Challenge18 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            evalCombo(line);
        }
    }

    private static int multiple = 0;

    private static void evalCombo(String combo) {
        int x = Integer.parseInt(combo.split(",")[0]);
        int n = multiple = Integer.parseInt(combo.split(",")[1]);
        checkNGreaterThanX(x, n);
    }

    private static void checkNGreaterThanX(int x, int n) {
        if (n > x) {
            System.out.println(n);
        } else {
            checkNGreaterThanX(x, n + multiple);
        }
    }
}
