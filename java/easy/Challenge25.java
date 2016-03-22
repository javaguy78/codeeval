package easy;

/**
 * Challenge 25 : Print all odd numbers
 * Created by cschalk on 3/21/16.
 */
public class Challenge25 {

    public static void main(String[] args) {
        for(int i = 1 ; i < 100 ; i+=2) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
