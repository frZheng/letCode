package top100;

//web https://leetcode-cn.com/problems/container-with-most-water


import list.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class  containerWithMostWater {
    private static class Solution {

        public Solution() {
        }

        public int maxArea(int[] height) {
            // 暴力解,超时
//            int result = 0;
//            for (int i = 0; i < height.length; ++i) {
//                for (int  j = i + 1; j < height.length; ++j) {
//                    result = Math.max((j - i)*Math.min(height[i], height[j]),result);
//                }
//            }
//            return result;

            int max = 0;
            for(int i = 0, j = height.length - 1; i < j ; ){
                int minHeight = height[i] < height[j] ? height[i++] : height[j--];
                max = Math.max(max, (j - i + 1) * minHeight);
            }
            return max;
        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] arr = {1,8,6,2,5,4,8,3,7};
        int lists = solution.maxArea(arr);
        System.out.println(lists);
    }

}
