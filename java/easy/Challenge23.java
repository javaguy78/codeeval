package easy;

/**
 * Challenge 23 : Multiplication Table
 * Created by cschalk on 4/11/16.
 */
public class Challenge23 {

    public static void main(String args[]) {
        for (int i = 1 ; i <= 12 ; ++i) {
            String line = "";
            for (int j = 1 ; j <= 12 ; ++j) {
                String answer = "    " + (i * j);
                line += answer.substring(answer.length() - 4);
            }
            System.out.println(line.trim());
        }
    }
}

