package top100;

//web https://leetcode.cn/problems/maximal-square


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class   maximalSquare {
    private static class Solution {

        public Solution() {
        }



        public int maximalSquare(char[][] matrix) {
            int maxSide = 0;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return maxSide;
            }

            int rows = matrix.length, columns = matrix[0].length;
            int[][] dp = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                dp[i][0] = matrix[i][0] - '0';
                if(dp[i][0]==1)
                    maxSide=1;
            }
            for (int i = 1; i < columns; i++) {
                dp[0][i] = matrix[0][i] - '0';
                if(dp[0][i]==1)
                    maxSide=1;
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

//        char[][] matrix = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}};
        char[][] matrix = {{'0','1'},{'1','0'}};
        int s = solution.maximalSquare(matrix);
        System.out.println(s);

    }
}
