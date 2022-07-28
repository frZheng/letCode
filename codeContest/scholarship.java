package codeContest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class scholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        int n = Integer.parseInt(next);
        int[][] sum = new int[n][3];
        for (int i = 0; i < n; ++i) {
            sum[i][2] = i+1;
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; ++j) {
                int val = Integer.parseInt(s[j]);
                sum[i][0] += val;
                if (j==0)
                    sum[i][1] = val;
            }


        }
        Arrays.sort(sum, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {

                for (int i = 0; i < a.length-1; ++i) {
                    if (a[i] != b[i]) {
                        return b[i] - a[i];//b[i] - a[i]降序
                    }
                }
                return a[2] - b[2];
            }
        });
        for (int i = 0; i < 5; ++i) {
            System.out.println(sum[i][2] + " " + sum[i][0]);
        }
    }
}