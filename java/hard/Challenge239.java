package hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Challenge 239 : Quick as a flash
 * Created by cschalk on 3/28/16.
 */
public class Challenge239 {

    static int pivots;

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                pivots = 0;
                runChallenge(line);
                System.out.println(pivots);
            }
        }
    }

    private static void runChallenge(String input) {
        int[] toSort = parseArray(input);
        quickSort(toSort, 0, toSort.length - 1);
    }

    private static int[]parseArray(String input) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : input.split(" ")) {
            list.add(Integer.parseInt(s));
        }
        int[] toReturn = new int[list.size()];
        for (int x = 0; x < list.size() ; x++) {
            toReturn[x] = list.get(x);
        }
        return toReturn;
    }

    static int partition(int[] arr, int left, int right) {
        int pivotValue = arr[left];
        int i = left;
        int j = right;
        for (;;) {
            while (arr[j] > pivotValue) j--;
            while (arr[i] < pivotValue) i++;
            if  (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            } else
                return j;
        }
    }

    static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        pivots++;
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index + 1 < right)
            quickSort(arr, index + 1, right);
    }
}
