package code.eval.easy.challenge_01;

import java.io.*;

// Challenge 1: Fizz Buzz
public class Main {

    private static int divisor1, divisor2, limit;

    public static void main(String[] args) {
        File file = new File(args[0]);

        if (!file.exists()) {
            System.err.println("Please specify a valid file name");
            System.exit(1);
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String gameInput;
            while ((gameInput = in.readLine()) != null) {
                playFizzBuzz(gameInput);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void playFizzBuzz(String gameInput) {
        parseGameNumbers(gameInput);
        playGame();
    }

    private static void parseGameNumbers(String input) {
        String[] vals = input.split(" ");
        try {
            divisor1 = Integer.parseInt(vals[0]);
            divisor2 = Integer.parseInt(vals[1]);
            limit = Integer.parseInt(vals[2]);
        } catch (Exception e) {
            System.err.println("Please enter numerical values only");
            System.exit(1);
        }
    }

    private static void playGame() {
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
