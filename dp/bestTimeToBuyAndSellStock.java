package dp;

//web https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
public class bestTimeToBuyAndSellStock {
    private static class Solution {

        public Solution() {
        }

        public int maxProfit(int[] prices) {
//            int low = Integer.MAX_VALUE;
//            int result = 0;
//            for (int i = 0; i < prices.length; ++i) {
//                low = Math.min(low, prices[i]);
//                result = Math.max(result, prices[i] - low);
//            }
//            return result;

            int len = prices.length;
            int[][] dp = new int[2][2];
            dp[0][0] -= prices[0];
//            dp[0][1] = 0;
            for (int i = 1; i < len; ++i) {
                dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], -prices[i]);
                dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], prices[i] + dp[(i - 1) % 2][0]);
            }
            return dp[(len - 1) % 2][1];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int [] cost = {7,1,5,3,6,4};
        int fib = solution.maxProfit(cost);
        System.out.println(fib);
    }
}
