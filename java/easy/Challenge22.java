package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 22 : Nth Fibonacci Digit
 * Created by cschalk on 3/21/16.
 */
public class Challenge22 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            nthFib(line);
        }
    }

    private static void nthFib(String input) {
        if (input != null && !input.isEmpty()) {
            int digit = Integer.parseInt(input);
            if (digit == 0) System.out.println(0);
            else if (digit == 1 || digit == 2) System.out.println(1);
            else {
                int a1 = 1, a2 = 1, tmp = 0;
                for (int i = 3; i <= digit; i++) {
                    tmp = a1 + a2;
                    a1 = a2;
                    a2 = tmp;
                }
                System.out.println(tmp);
            }
        }
    }
}
