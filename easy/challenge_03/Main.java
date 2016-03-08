package code.eval.easy;

// Largest palindrome prime less than 1000
public class Challenge3 {

    public static void main(String[] args) {
        for (int i = 1000; i > 0; i--) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }

    private static boolean isPrime(int in) {
        if (in <= 1) { return false; }
        if (in == 2) { return true; }
        for (int i = 2 ; i < Math.sqrt(in) + 1 ; i++ ) {
            if (in % i == 0) { return false; }
        }
        return true;
    }

    private static boolean isPalindrome(int in) {
        String strIn = "" + in;
        for (int i = 0; i <= (strIn.length() / 2) ; i++ ) {
            if (strIn.charAt(i) != strIn.charAt(strIn.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }

}
