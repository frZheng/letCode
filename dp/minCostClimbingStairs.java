package dp;

//web https://leetcode-cn.com/problems/min-cost-climbing-stairs/
public class minCostClimbingStairs {
    private static class Solution {

        public Solution() {
        }

        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            int[] dp = new int[len];
            dp[0] = cost[0];
            dp[1] = cost[1];

            for (int i = 2; i < len; ++i) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
            return Math.min(dp[len - 1], dp[len - 2]);
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int [] cost = {10,15,20};
        int fib = solution.minCostClimbingStairs(cost);
        System.out.println(fib);
    }
}
