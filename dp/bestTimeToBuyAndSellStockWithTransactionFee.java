package dp;

//web https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
public class bestTimeToBuyAndSellStockWithTransactionFee {
    private static class Solution {

        public Solution() {
        }

        public int maxProfit(int[] prices, int fee) {
            if (prices == null) return 0;
            int len = prices.length;
            if(len < 1) return 0;

            int[][] dp = new int[len][2];
            dp[0][1] = -prices[0];
            for (int i = 1; i < len; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[len - 1][0];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int [] cost = {1, 3, 2, 8, 4, 9};
        int fib = solution.maxProfit(cost, 2);
        System.out.println(fib);
    }
}
