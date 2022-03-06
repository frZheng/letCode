package dp;

//web https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
public class longestContinuousIncreasingSubsequence {
    private static class Solution {

        public Solution() {
        }

        public static int findLengthOfLCIS(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
            }
            int res = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] > nums[i]) {
                    dp[i + 1] = dp[i] + 1;
                }
                res = res > dp[i + 1] ? res : dp[i + 1];
            }
            return res;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int [] cost = {1,3,5,4,7};
        int fib = solution.findLengthOfLCIS(cost);
        System.out.println(fib);
    }
}
