package top100;

//web https://leetcode.cn/problems/sliding-window-maximum


import java.util.*;

public class  slidingWindowMaximum {
    private static class Solution {

        public Solution() {
        }

//        public int[] maxSlidingWindow(int[] nums, int k) {
//            int len = nums.length;
//            int newLen = len - k + 1;
//            int[] result = new int[newLen];
//            for (int i = 0; i < newLen; ++i) {
//                result[i] = nums[i];
//                for (int j = 1; j < k; ++j) {
//                    result[i] = Math.max(result[i],nums[i+j]);
//                }
//            }
//            return result;
//        }
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] prefixMax = new int[n];
            int[] suffixMax = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i % k == 0) {
                    prefixMax[i] = nums[i];
                }
                else {
                    prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
                }
            }
            for (int i = n - 1; i >= 0; --i) {
                if (i == n - 1 || (i + 1) % k == 0) {
                    suffixMax[i] = nums[i];
                } else {
                    suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
                }
            }
            int newLen = n - k + 1;
            int[] ans = new int[newLen];
            for (int i = 0; i < newLen; ++i) {
                ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
            }
            return ans;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

//        int[] lists = solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        int[] lists = solution.maxSlidingWindow(new int[]{1},1);
        for (int i : lists)
            System.out.println(i);


    }
}
