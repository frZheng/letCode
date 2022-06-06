package top100;

//web https://leetcode.cn/problems/perfect-squares


import java.util.*;

public class  perfectSquares {
    private static class Solution {

        public Solution() {
        }
        public int numSquares(int n) {
            int[] f = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int minn = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    minn = Math.min(minn, f[i - j * j]);
                }
                f[i] = minn + 1;
            }
            return f[n];
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int res = solution.numSquares(12);

        System.out.println(res);


    }
}
