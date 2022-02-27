package dp;

//web https://leetcode-cn.com/problems/climbing-stairs/
public class climbingStairs {
    private static class Solution {

        public Solution() {
        }
        public int climbStairs(int n) {
            if (n < 2) return 1;
            int[] dp = new int[2];
            dp[0] = 1;
            dp[1] = 1;
            int sum = 0;
            for (int i = 2; i <= n; ++i) {
                sum = dp[0] + dp[1];
                dp[0] = dp[1];
                dp[1] = sum;
            }
            return sum;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int fib = solution.climbStairs(3);
        System.out.println(fib);
    }
}
