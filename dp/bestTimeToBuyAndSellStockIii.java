package dp;

//web https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
public class bestTimeToBuyAndSellStockIii {
    private static class Solution {

        public Solution() {
        }

        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 1) return 0;
            int[] dp = new int[5];

            dp[1] = -prices[0];
            dp[3] = -prices[0];

            for (int i = 1; i < len; ++i) {
                dp[1] = Math.max(dp[1], dp[0] - prices[i]);
                dp[2] = Math.max(dp[2], dp[1] + prices[i]);
                dp[3] = Math.max(dp[3], dp[2] - prices[i]);
                dp[4] = Math.max(dp[4], dp[3] + prices[i]);
            }
            return dp[4];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int [] cost = {7,1,5,3,6,4};
        int fib = solution.maxProfit(cost);
        System.out.println(fib);
    }
}
