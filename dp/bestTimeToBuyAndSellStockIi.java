package dp;

//web https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
public class bestTimeToBuyAndSellStockIi {
    private static class Solution {

        public Solution() {
        }

        public int maxProfit(int[] prices) {
            int len = prices.length;

            int[][] dp = new int[2][2];
            dp[0][0] = -prices[0];
            int last, now;

            for (int i = 1; i < len; ++i) {
                last = (i - 1) % 2;
                now = i % 2;
                dp[now][0] = Math.max(dp[last][0], dp[last][1] - prices[i]); // 持有股票所得现⾦
                dp[now][1] = Math.max(dp[last][0] + prices[i], dp[last][1]); // 不持有股票所得最多现⾦
            }
            now = (len - 1) % 2;
            return dp[now][1];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int [] cost = {7,1,5,3,6,4};
        int fib = solution.maxProfit(cost);
        System.out.println(fib);
    }
}
