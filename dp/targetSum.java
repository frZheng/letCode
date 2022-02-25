package dp;

//web https://leetcode-cn.com/problems/unique-binary-search-trees/
public class targetSum {
    private static class Solution {

        public Solution() {
        }

        public int findTargetSumWays(int[] nums, int target) {
            int size = nums.length;
//            if (size == 1) return nums[0]
            int sum = nums[0];
            for (int i = 1; i < size; ++i) sum += nums[i];
            if (Math.abs(target) > sum) return 0;
            if ((sum + target) % 2 == 1) return 0;
            int bagSize = (target + sum) >> 1;
            int[] dp = new int[bagSize + 1];
            dp[0] = 1;
            for (int i = 0; i < size; ++i){
                for (int j = bagSize; j >= nums[i]; --j){
                    dp[j] += dp[j - nums[i]]; // 得到 j-nums[i]
                }
            }
//            for (int i = 0; i < bagSize + 1; ++i)
//                System.out.println(dp[i]);
            return dp[bagSize];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,1,1};
        int fib = solution.findTargetSumWays(nums, 3);
        System.out.println(fib);
    }
}
