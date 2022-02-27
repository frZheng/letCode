package dp;

//web https://leetcode-cn.com/problems/coin-change-2/submissions/
public class combinationSumIv {
    private static class Solution {

        public Solution() {
        }

        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i <= target; ++i) {
                for (int num : nums) {
                    if (i >= num) {
                        dp[i] += dp[i-num];
                    }
                }
            }
            return dp[target];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        int fib = solution.combinationSum4(nums, 4);
        System.out.println(fib);
    }
}
