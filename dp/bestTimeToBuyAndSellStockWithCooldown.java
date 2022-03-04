package dp;

//web https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
public class bestTimeToBuyAndSellStockWithCooldown {
    private static class Solution {

        public Solution() {
        }

        public int maxProfit(int[] prices) {
            if (prices == null) return 0;
            int len = prices.length;
            if (len < 2) return 0;
            int[][] dp = new int[len][2];

//            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
            dp[1][1] = Math.max(dp[0][1], -prices[1]);
            for (int i = 2; i < len; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
            return dp[len -  1][0];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int [] cost = {1,11,2,7,4};
        int fib = solution.maxProfit(cost);
        System.out.println(fib);
    }
}
