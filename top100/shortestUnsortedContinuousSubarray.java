package top100;

//web https://leetcode.cn/problems/shortest-unsorted-continuous-subarray


import java.util.*;

public class   shortestUnsortedContinuousSubarray {
    private static class Solution {

        public Solution() {
        }


        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int maxn = Integer.MIN_VALUE, right = -1;
            int minn = Integer.MAX_VALUE, left = -1;
            for (int i = 0; i < n; i++) {
                if (maxn > nums[i]) {
                    right = i;
                } else {
                    maxn = nums[i];
                }
                if (minn < nums[n - i - 1]) {
                    left = n - i - 1;
                } else {
                    minn = nums[n - i - 1];
                }
            }
            return right == -1 ? 0 : right - left + 1;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();
//        int[] nums={2,6,4,8,10,9,15};
//        int[] nums={1,2,3,4};
//        int[] nums={1};
//        int[] nums={2,3,3,2,4};
//        int[] nums={2,1};
        int[] nums={1,3,2};
        int s = solution.findUnsortedSubarray(nums);
        System.out.println(s);

    }
}
