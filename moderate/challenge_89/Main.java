package code.eval.moderate.challenge_89;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

// Challenge 89: Pass Triangle
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
        Stack<ArrayList<Integer>> triangle = new Stack<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String input;
            while ((input = in.readLine()) != null) {
                ArrayList<Integer> found = new ArrayList<>();
                for (String s : input.split(" ")) {
                    found.add(Integer.parseInt(s));
                }
                triangle.push(found);
            }

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }

        runChallenge(triangle);
    }

    private static void runChallenge(Stack<ArrayList<Integer>> triangle) {
        ArrayList<Integer> bottom = triangle.pop();
        do {
            bottom = eval(triangle.pop(), bottom);
        } while (!triangle.empty());

        System.out.println(bottom.get(0));
    }

    private static ArrayList<Integer> eval(ArrayList<Integer> top, ArrayList<Integer> bottom) {
        for (int i = 0 ; i < top.size() ; i++) {
            int topInt = top.get(i);
            int first = bottom.get(i);
            int second = bottom.get(i+1);
            top.set(i, Math.max(topInt + first, topInt + second));
        }
        return top;
    }
}
