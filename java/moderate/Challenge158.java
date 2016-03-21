package code.eval.moderate.challenge_158;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Challenge 158: Partial Bubble Sort
public class Main {
    static File inputFile;

    public static void main(String[] args) {
        getInputFile(args[0]);
        doWork();
    }

    private static void getInputFile(String fileName) {
        inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.err.println("Please specify a valid file name");
            System.exit(1);
        }
    }

    private static void doWork() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String input;
            while ((input = in.readLine()) != null) {
                runChallenge(input);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void runChallenge(String input) {
        String[] challenge = input.split("\\|");
        int[] toSort = parseChallengeString(challenge[0]);
        long loops = Long.parseLong(challenge[1].trim());
        int[] sorted = partiallyBubbleSort(toSort, loops);

        String out = "";
        for (Integer i : sorted) {
            out+=("" + i).concat(" ");
        }

        System.out.println(out.trim());
    }

    private static int[] parseChallengeString(String in){
        String[] list = in.split(" ");
        int [] toReturn = new int[list.length];
        for (int i = 0 ; i < list.length ; i++ ) {
            toReturn[i] = Integer.parseInt(list[i]);
        }
        return toReturn;
    }

    private static int[] partiallyBubbleSort(int[] list, long loops) {
        if (loops > list.length) loops = list.length;
        for (long i = 0 ; i < loops ; i++) {
            for (int j = 0 ; j < list.length - 1 ; j++) {
                if (list[j] > list[j+1]) {
                    int tmp = list[j];
                    list[j] = list [j + 1];
                    list[j + 1] = tmp;
                }
            }
        }
        return list;
    }
}
