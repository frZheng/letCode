package top100;

//web https://leetcode.cn/problems/search-a-2d-matrix-ii


import java.util.*;

public class  searchA2dMatrixIi {
    private static class Solution {

        public Solution() {
        }
        public boolean searchMatrix(int[][] matrix, int target) {
            int col = matrix.length, row = matrix[0].length;
            int x = 0, y = row - 1;
            while (x < col && y >= 0) {
                if (matrix[x][y] == target) {
                    return true;
                }
                if (matrix[x][y] > target) {
                    --y;
                } else {
                    ++x;
                }
            }
            return false;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

//        int[] lists = solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        boolean res = solution.searchMatrix(matrix,5);

        System.out.println(res);


    }
}
