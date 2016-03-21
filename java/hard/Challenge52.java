package code.eval.hard.challenge_52;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Challenge 52: Text representation of Integers
public class Main {

    static File inputFile;

    public static void main(String[] args) {
        getInputFile(args[0]);
        doWork();
    }

    private static void getInputFile(String fileName) {
        inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.err.println("Please specify a valid file name");
            System.exit(1);
        }
    }

    private static void doWork() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String number;
            while ((number = in.readLine()) != null) {
                numberToWords(number);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void numberToWords(String number) {
        String numberWithPaddedZeros = "0000000000" + number;
        String hundreds = numberWithPaddedZeros.substring(numberWithPaddedZeros.length() - 3, numberWithPaddedZeros.length());
        String thousands = numberWithPaddedZeros.substring(numberWithPaddedZeros.length() - 6, numberWithPaddedZeros.length() - 3);
        String millions = numberWithPaddedZeros.substring(numberWithPaddedZeros.length() - 9, numberWithPaddedZeros.length() - 6);

        StringBuilder toReturn = new StringBuilder();
        if (!"000".equals(millions)) {
            toReturn.append(decodeTriplet(millions)).append("Million");
        }
        if (!"000".equals(thousands)) {
            toReturn.append(decodeTriplet(thousands)).append("Thousand");
        }
        if (!"000".equals(hundreds)) {
            toReturn.append(decodeTriplet(hundreds));
        }

        if (!toReturn.toString().isEmpty()) {
            toReturn.append("Dollars");
            System.out.println(toReturn.toString().trim());
        }
    }

    private static String decodeTriplet(String triplet) {
        StringBuilder toReturn = new StringBuilder();
        if ('0' != triplet.charAt(0)) {
            toReturn.append(decodeSingle(triplet.charAt(0))).append("Hundred");
        }

        if ('1' == triplet.charAt(1)) {
            toReturn.append(decodeTeens(triplet.charAt(2)));
        } else {
            toReturn.append(decodeTens(triplet.charAt(1)));
            toReturn.append(decodeSingle(triplet.charAt(2)));
        }
        return toReturn.toString().trim();
    }

    private static String decodeTens(char in) {
        return decodeNumber(in, true, false, false);
    }

    private static String decodeTeens(char in) {
        return decodeNumber(in, false, true, false);
    }

    private static String decodeSingle(char in) {
        return decodeNumber(in, false, false, true);
    }

    private static String decodeNumber(char in, boolean tens, boolean teens, boolean single) {
        switch (in) {
            case '1':
                if (tens) return "TEEN";
                if (teens) return "Eleven";
                if (single) return "One";
                break;
            case '2':
                if (tens) return "Twenty";
                if (teens) return "Twelve";
                if (single) return "Two";
                break;
            case '3':
                if (tens) return "Thirty";
                if (teens) return "Thirteen";
                if (single) return "Three";
                break;
            case '4':
                if (tens) return "Forty";
                if (teens) return "Fourteen";
                if (single) return "Four";
                break;
            case '5':
                if (tens) return "Fifty";
                if (teens) return "Fifteen";
                if (single) return "Five";
                break;
            case '6':
                if (tens) return "Sixty";
                if (teens) return "Sixteen";
                if (single) return "Six";
                break;
            case '7':
                if (tens) return "Seventy";
                if (teens) return "Seventeen";
                if (single) return "Seven";
                break;
            case '8':
                if (tens) return "Eighty";
                if (teens) return "Eighteen";
                if (single) return "Eight";
                break;
            case '9':
                if (tens) return "Ninety";
                if (teens) return "Nineteen";
                if (single) return "Nine";
                break;
            case '0':
                if (teens) return "Ten";
        }
        return "";
    }
}