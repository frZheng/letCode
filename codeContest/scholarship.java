package codeContest;

import java.util.Scanner;

public class scholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        int n = Integer.parseInt(next);
        int[][] sum = new int[n][2];
        for (int i = 0; i < n; ++i) {
            sum[i][0] = i;
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; ++j)
                sum[i][1] += Integer.parseInt(s[j]);
        }
        for (int i = 0; i < 6; ++i) {

        }
    }
}
