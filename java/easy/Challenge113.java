package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 113 : Multiply Lists
 * Created by cschalk on 4/11/16.
 */
public class Challenge113 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            runChallenge(line);
        }
    }

    private static void runChallenge(String input) {
        String sets[] = input.split("\\|");
        String set1[] = sets[0].trim().split(" ");
        String set2[] = sets[1].trim().split(" ");
        for (int i = 0 ; i < set1.length ; ++i) {
            int ans = Integer.parseInt(set1[i]) * Integer.parseInt(set2[i]);
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}
