package top100;

 //web https://leetcode-cn.com/problems/minimum-path-sum


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class  minimumPathSum {
    private static class Solution {

        public Solution() {
        }


        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; ++i) dp[i][0] = grid[i][0] + dp[i-1][0];
            for (int i = 1; i < n; ++i) dp[0][i] = grid[0][i] + dp[0][i-1];
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
            return dp[m-1][n-1];
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int lists = solution.minPathSum(grid);
        System.out.println(lists);


    }
}
