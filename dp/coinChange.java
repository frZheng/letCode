package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

//web https://leetcode-cn.com/problems/coin-change/
public class coinChange {
    private static class Solution {

        public Solution() {
        }

        public int coinChange(int[] coins, int amount) {
            int len = coins.length;
            if (len < 1) return -1;
            int[] dp = new int[amount + 1];
//            Arrays.fill(dp, 1, len, Integer.MAX_VALUE); // 无法使用
            for (int j = 1; j <= amount; ++j) {
                dp[j] = Integer.MAX_VALUE;
            }
//            dp[0] = 0;
            for (int coin : coins) {
                for (int j = coin; j <= amount; ++j) {
                    if (dp[j - coin] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                    }
                }
//                String str = "";
//                str += coin;
//                str += ": ";
//                for (int j = coin; j <= amount; ++j) {
////                    System.out.println(dp[j]);
//                    str += dp[j];
//                    str += ",";
//                }
//                System.out.println(str);
            }
            return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int fib = solution.coinChange(coins, 11);
        System.out.println(fib);
    }
}
