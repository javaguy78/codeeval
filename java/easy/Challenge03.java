package code.eval.easy.challenge_03;

// Challenge 3: Largest palindrome prime less than 1000
public class Main {

    public static void main(String[] args) {
        for (int i = 1000; i > 0; i--) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }

    private static boolean isPrime(int in) {
        switch (in) {
            case 1  : return false;
            case 2  : return true;
            default :
                // get rid of evens
                if (in % 2 == 0) return false;

                // efficiently loop through rest
                for (int i = 3; i < Math.sqrt(in) + 1; i++) {
                    if (in % i == 0) return false;
                }
        }
        return true;
    }

    private static boolean isPalindrome(int in) {
        String strIn = "" + in;
        for (int i = 0, j = strIn.length() - 1; i < j ; i++, j-- ) {
            if (strIn.charAt(i) != strIn.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
