package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 93 : Capitalize Strings
 * Created by cschalk on 3/21/16.
 */
public class Challenge93 {
    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            capitalizeString(line);
        }
    }

    private static void capitalizeString(String input) {
        String[] words = input.split(" ");
        String output = "";
        for (String word : words) {
            output += capitalize(word).concat(" ");
        }
        System.out.println(output.trim());
    }

    private static String capitalize(String word) {
        String toReturn = ("" + word.charAt(0)).toUpperCase();
        return toReturn + word.substring(1);
    }
}
