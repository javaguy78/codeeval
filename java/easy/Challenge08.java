package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 08 : Reverse Words
 * Created by cschalk on 3/21/16.
 */
public class Challenge08 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            reverseSentence(line);
        }
    }

    private static void reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        String reverse = "";
        for (String word : words) {
            reverse = word + " " + reverse;
        }
        System.out.println(reverse.trim());
    }
}
