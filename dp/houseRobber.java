package dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//web https://leetcode-cn.com/problems/house-robber/
public class houseRobber {
    private static class Solution {

        public Solution() {
        }

        public int rob(int[] nums) {

            int len = nums.length;
            if (len == 1) return nums[0];
//            else if (len == 2) return Math.max(nums[0], nums[1]);
            int[] dp = new int[len ];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; ++i) {
                dp[i] = Math.max(dp[i - 1], dp[i-2] + nums[i]);
//                System.out.println(dp[i]);
            }
            return dp[len - 1];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {2,1,1,2};
        int fib = solution.rob(nums);
        System.out.println(fib);
    }
}
