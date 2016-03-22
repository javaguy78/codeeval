package moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 158 : Interrupted Bubble Sort
 * Created by cschalk on 3/21/16.
 */
public class Challenge158 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
             runChallenge(line);
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
