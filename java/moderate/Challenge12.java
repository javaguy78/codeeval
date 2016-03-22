package moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Challenge 12 : First non-duplicate letter
 * Created by cschalk on 3/21/16.
 */
public class Challenge12 {
    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            runChallenge(line);
        }
    }

    private static void runChallenge(String input) {
        ArrayList<String> foundLetters = new ArrayList<>();
        ArrayList<String> foundDuplicates = new ArrayList<>();
        for (char c : input.toCharArray()) {
            String work = "" + c;
            if (!foundDuplicates.contains(work)) {
                if (!foundLetters.contains(work)) {
                    foundLetters.add(work);
                } else {
                    foundLetters.remove(work);
                    foundDuplicates.add(work);
                }
            }
        }
        if (foundLetters.size() > 0)
            System.out.println(foundLetters.get(0));
    }
}
