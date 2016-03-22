package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Challenge 20 : Strings to Lower Case
 * Created by cschalk on 3/21/16.
 */
public class Challenge20 {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(line.toLowerCase());
        }
    }
}
