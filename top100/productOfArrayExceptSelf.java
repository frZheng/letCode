package top100;

//web https://leetcode.cn/problems/product-of-array-except-self


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class   productOfArrayExceptSelf {
    private static class Solution {

        public Solution() {
        }


        public int[] productExceptSelf(int[] nums) {
            int size = nums.length;
            int[] left = new int[size];
            int[] right = new int[size];
            int[] result = new int[size];
            for (int i = 0; i < size; ++i) {
                left
            }
            return result;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int[] nums = {1,2,3,4};
        int[] s = solution.productExceptSelf(nums);
        for (int i : s)
            System.out.println(i);

    }
}
