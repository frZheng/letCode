package offer;

 //web https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof


import java.util.ArrayList;
import java.util.List;

public class shunShiZhenDaYinJuZhenLcof {
    private static class Solution {

        public Solution() {
        }
        public int[] spiralOrder(int[][] matrix) {
            int left=0, right=0, low=0, high=0;
            right = matrix[0].length;
            high = matrix.length;
            int[] result = new int[right * high];
            int index = 0;
            while (true) {
//                int index_row,index_col;
                int i,j;
//                i = low;
                j = left;
                for (; j < right; ++j){
                    result[index++] = matrix[low][j];
                }
                System.out.println(index);
                low++;

                i = low;
//                j = right - 1;
                for (; i < high; ++i){
                    result[index++] = matrix[i][right-1];
                }
                System.out.println(index);
                right--;


//                i = high - 1;
                j = right - 1;
                for (; j >= left; --j){
                    result[index++] = matrix[high - 1][j];
                }
                System.out.println(index);
                high--;

                i = high - 1;
//                j = left;
                for (; i >= low; --i){
                    result[index++] = matrix[i][left];
                }
                System.out.println(index);
                left++;


                if(left > right || low > high || index >= result.length)
                    break;
            }
            return result;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] bs = solution.spiralOrder(nums);
        String msg = "";
        for (int b : bs)
            msg += b + " ";
        System.out.println(msg);
    }



}

