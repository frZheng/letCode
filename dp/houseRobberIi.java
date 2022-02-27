package dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//web https://leetcode-cn.com/problems/house-robber-ii
public class houseRobberIi {
    private static class Solution {

        public Solution() {
        }

        int robAction(int[] nums, int start, int end) {
//            int x = 0, y = 0, z = 0;
            int[] dp = new int[2];
            int sums = 0;
            for (int i = start; i < end; ++i) {
                sums = Math.max(dp[1], dp[0] + nums[i]);
                dp[0] = dp[1];
                dp[1] = sums;
            }
            return sums;
        }
        public int rob(int[] nums) {

            if (nums == null)return 0;
            int len = nums.length;
            if (len == 1) return nums[0];
            return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1};
        int fib = solution.rob(nums);
        System.out.println(fib);
    }
}
