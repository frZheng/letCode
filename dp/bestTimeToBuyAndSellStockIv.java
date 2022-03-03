package dp;

//web https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
public class bestTimeToBuyAndSellStockIv {
    private static class Solution {

        public Solution() {
        }

        public int maxProfit(int k, int[] prices) {
            int len = prices.length;
            if (len == 0) return 0;
            int[][] dp = new int[len][k * 2 + 1];
            for (int j = 1; j < 2 * k; j += 2) {
                dp[0][j] = -prices[0];
            }
            for (int i = 1; i < len; ++i) {
                for (int j = 0; j < 2 * k - 1; j += 2) {
                    dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                    dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
                }
            }
            return dp[len - 1][2 * k];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int [] cost = {3,2,6,5,0,3};
        int fib = solution.maxProfit(2, cost);
        System.out.println(fib);
    }
}
