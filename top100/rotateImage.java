package top100;

//web https://leetcode-cn.com/problems/rotate-image


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class  rotateImage {
    private static class Solution {

        public Solution() {
        }


        public void rotate(int[][] matrix) {
            int len = matrix.length;
            for (int i = 0; i < len / 2; i++) {
                int end = len - i - 1;
                for (int j = 0; j < end - i; j++) {
                    int temp = matrix[i][i + j];
                    matrix[i][i + j] = matrix[end - j][i];
                    matrix[end - j][i] = matrix[end][end - j];
                    matrix[end][end - j] = matrix[i + j][end];
                    matrix[i + j][end] = temp;
                }
            }

//            int n = matrix.length;
////            int[][] ints = new int[n][n];
//            int[][] ints = Arrays.copyOf(matrix, n * n);
//            for (int i = 0; i < n; ++i) {
//                System.arraycopy(ints[n - i - 1], 0, matrix[i], 0, n);
//            }



//            for (int i = 0; i < n; ++i) {
//                for (int j = 0; j < n; ++j) {
//                    matrix[j][i] = ints[i][j];
//                }
//            }



        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.rotate(arr);
        for (int[] arr1 : arr) {
            StringBuilder msg = new StringBuilder();
            for (int i : arr1){
                msg.append(i).append(",");
            }
            System.out.println(msg);
        }


    }
}
