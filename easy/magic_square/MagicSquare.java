package code.eval.easy.magic_square;

import java.util.Arrays;

public class MagicSquare {

    public static void main(String args[]) {

        for (int a = 1; a < 100; ++a) {
            int[] answer = new int[9];
            answer[0] = a;
            for (int b = 1; b < 100; ++b) {
                if (a == b) continue;
                answer[1] = b;
                for (int c = 1; c < 100; ++c) {
                    if (a == c || b == c) continue;
                    answer[2] = c;
                    for (int d = 1; d < 100; ++d) {
                        if (a == d || b == d || c == d) continue;
                        answer[3] = d;
                        for (int e = 1; e < 100; ++e) {
                            if (a == e || b == e || c == e || d == e) continue;
                            answer[4] = e;
                            for (int f = 1; f < 100; ++f) {
                                if (a == f || b == f || c == f || d == f || e == f) continue;
                                answer[5] = f;
                                int row1 = (a * a) + (b * b) + (c * c);
                                int row2 = (d * d) + (e * e) + (f * f);
                                if (row1 == row2) {
                                    for (int g = 1; g < 100; ++g) {
                                        if (a == g || b == g || c == g || d == g || e == g || f == g) continue;
                                        answer[6] = g;
                                        int col1 = (a * a) + (d * d) + (g * g);
                                        if (col1 == row1) {
                                            for (int h = 1; h < 100; ++h) {
                                                if (a == h || b == h || c == h || d == h || e == h || f == h || g == h)
                                                    continue;
                                                answer[7] = h;
                                                int col2 = (b * b) + (e * e) + (h * h);
                                                if (col2 == row1) {
                                                    for (int i = 1; i < 100; ++i) {
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
                                                                    System.out.println("Found It! - " + row1);
                                                                    System.out.println(Arrays.toString(answer));
                                                                    System.exit(0);
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
    }
}
