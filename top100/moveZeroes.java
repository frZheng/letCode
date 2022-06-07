package top100;

//web https://leetcode.cn/problems/move-zeroes


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class   moveZeroes {
    private static class Solution {

        public Solution() {
        }


        public void moveZeroes(int[] nums) {
            int zeroNums = 0;
            int len = nums.length;
            for (int i = 0; i < len; ++i) {
                if (nums[i] == 0) {
                    zeroNums++;
                }
                else {
                    nums[i - zeroNums] = nums[i];
                }
            }
            for (int i = 0; i < zeroNums; ++i){
                nums[len-1-i] = 0;
            }
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

//        int[] nums = {0,1,0,3,12};
        int[] nums = {0};
        for (int i :nums)
            System.out.println(i);
        solution.moveZeroes(nums);
        System.out.println("ok");
        for (int i :nums)
            System.out.println(i);

    }
}
