package dp;

//web https://leetcode-cn.com/problems/maximum-subarray
public class maximumSubarray {
    private static class Solution {

        public Solution() {
        }

        public int maxSubArray(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int res = nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                res = res > dp[i] ? res : dp[i];
            }
            return res;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int fib = solution.maxSubArray(nums);
        System.out.println(fib);
    }
}
