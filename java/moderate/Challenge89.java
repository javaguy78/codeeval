package moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Challenge 89 : Pass Triangle
 * Created by cschalk on 3/21/16.
 */
public class Challenge89 {

    public static void main (String[] args) throws Exception {
        Stack<ArrayList<Integer>> triangle = new Stack<>();
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            ArrayList<Integer> found = new ArrayList<>();
            for (String s : line.split(" ")) {
                found.add(Integer.parseInt(s));
            }
            triangle.push(found);
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
