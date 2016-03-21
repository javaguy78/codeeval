package code.eval.easy.challenge_25;

// Challenge 25: Odd Numbers
public class Main {

    public static void main(String[] args) {
        for(int i = 1 ; i < 100 ; i+=2) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

}
