package code.eval.java.magic_square;

import java.util.Arrays;

public class MagicSquare {

    public static void main(String args[]) {
        int[] answer = null;
        int min = 1;
        int max = 200;

        for (int a = min; a < max; ++a) {
            answer = new int[9];
            answer[0] = a;
            for (int b = min; b < max; ++b) {
                if (a == b) continue;
                answer[1] = b;
                for (int c = min; c < max; ++c) {
                    if (a == c || b == c) continue;
                    answer[2] = c;
                    for (int d = min; d < max; ++d) {
                        if (a == d || b == d || c == d) continue;
                        answer[3] = d;
                        for (int e = min; e < max; ++e) {
                            if (a == e || b == e || c == e || d == e) continue;
                            answer[4] = e;
                            for (int f = min; f < max; ++f) {
                                if (a == f || b == f || c == f || d == f || e == f) continue;
                                answer[5] = f;
                                int row1 = (a * a) + (b * b) + (c * c);
                                int row2 = (d * d) + (e * e) + (f * f);
                                if (row1 == row2) {
                                    for (int g = min; g < max; ++g) {
                                        if (a == g || b == g || c == g || d == g || e == g || f == g) continue;
                                        answer[6] = g;
                                        int col1 = (a * a) + (d * d) + (g * g);
                                        if (col1 == row1) {
                                            for (int h = min; h < max; ++h) {
                                                if (a == h || b == h || c == h || d == h || e == h || f == h || g == h)
                                                    continue;
                                                answer[7] = h;
                                                int col2 = (b * b) + (e * e) + (h * h);
                                                if (col2 == row1) {
                                                    for (int i = min; i < max; ++i) {
                                                        if (a == i || b == i || c == i || d == i || e == i || f == i || g == i || h == i)
                                                            continue;
                                                        answer[8] = i;
                                                        int row3 = (g * g) + (h * h) + (i * i);
                                                        int col3 = (c * c) + (f * f) + (i * i);
                                                        if (row3 == row1 && col3 == row1) {
                                                            int diag1 = (a * a) + (e * e) + (i * i);
                                                            if (diag1 == row3) {
                                                                int diag2 = (g * g) + (e * e) + (c * c);
                                                                if (diag2 == diag1) {
                                                                    System.out.println("Found One! - " + row1);
                                                                    System.out.println(Arrays.toString(answer));
                                                                } else {
                                                                    System.err.println("Parker Square! = " + row1);
                                                                    System.err.println(Arrays.toString(answer));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (answer != null) {
            System.out.println(Arrays.toString(answer));
        }
    }
}
