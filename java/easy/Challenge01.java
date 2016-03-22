package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 01 : FizzBuzz
 * Created by cschalk on 3/21/16.
 */
public class Challenge01 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            playFizzBuzz(line);
        }
    }

    private static void playFizzBuzz(String input) {
        String[] values = input.split(" ");
        int divisor1 = Integer.parseInt(values[0]);
        int divisor2 = Integer.parseInt(values[1]);
        int limit = Integer.parseInt(values[2]);

        StringBuilder out = new StringBuilder();
        for (int i = 1 ; i <= limit ; i++) {
            boolean fizz = i % divisor1 == 0;
            boolean buzz = i % divisor2 == 0;
            if (fizz && buzz) {
                out.append("FB ");
            } else if (fizz) {
                out.append("F ");
            } else if (buzz) {
                out.append("B ");
            } else {
                out.append(i).append(" ");
            }
        }
        System.out.println(out.toString().trim());
    }
}
