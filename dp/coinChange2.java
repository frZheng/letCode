package dp;

//web https://leetcode-cn.com/problems/coin-change-2/submissions/
public class coinChange2 {
    private static class Solution {

        public Solution() {
        }

        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for(int coin : coins) {
                for (int j =0; j <= amount; ++j) {
                    if (j >= coin) {
                        dp[j] += dp[j - coin]; // 金额j 应该是[1,2, ..., j-1]可能的总和
                    }
                }
            }
            return dp[amount];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int fib = solution.change(5, coins);
        System.out.println(fib);
    }
}
