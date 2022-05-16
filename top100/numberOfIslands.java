package top100;

//web https://leetcode.cn/problems/number-of-islands


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class   numberOfIslands {
    private static class Solution {

        public Solution() {
        }


        public int numIslands(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] vistied = new boolean[row][col];
            int [] rowStep = {1, 0, -1, 0};
            int [] colStep = {0, 1, 0, -1};
            int res = 0;
            for (int i = 0; i < row; ++i) {
                for (int j= 0; j < col; ++j) {

                    int dfs = dfs(i, j, grid, vistied, rowStep, colStep);
//                    System.out.println(i+","+j+","+dfs);
                    res +=dfs;
                }
            }
            return res;
        }

        private int dfs(int row, int col, char[][] grid, boolean[][] vistied,int [] rowStep, int [] colStep) {
            if (row < 0 || row >= grid.length ||
               col < 0 || col >= grid[0].length ||
            vistied[row][col] || grid[row][col]=='0' )
                return 0;
            else {
//                if (grid[row][col] == '1') {
//                    vistied[row][col] = true;
//                    boolean flag = true;
//                    for (int i = 0; i < rowStep.length; ++i) {
//                        int dfs = dfs(row + rowStep[i], col + colStep[i], grid, vistied, rowStep, colStep);
//                        if (dfs == 1) flag = false;
//                    }
//                    if (flag)
//                        vistied[row][col] = false;
//                } else {
//                    return 0;
//                }

                vistied[row][col] = true;

                for (int i = 0; i < rowStep.length; ++i) {
                    dfs(row + rowStep[i], col + colStep[i], grid, vistied, rowStep, colStep);
                }
            }
            return 1;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
//        char[][] grid = {
//            {'1','1','0','0','0'},
//            {'1','1','0','0','0'},
//            {'0','0','1','0','0'},
//            {'0','0','0','1','1'}
//        };


        int s = solution.numIslands(grid);
        System.out.println(s);

    }
}
