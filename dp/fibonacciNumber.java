package dp;

//web https://leetcode-cn.com/problems/fibonacci-number/submissions/
public class fibonacciNumber {
    private static class Solution {

        public Solution() {
        }
        public int fib(int n) {
            if (n <= 1) return n;
            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = 1;
            int sum = 0;
            for (int i = 2; i <= n; ++i) {
                sum = dp[0] + dp[1];
                dp[0] = dp[1];
                dp[1] = sum;
//                dp[i] = dp[i - 1] + dp[i - 2];
//                System.out.println(dp[i]);
            }
            return sum;
//            return dp[n];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int fib = solution.fib(10);
        System.out.println(fib);
    }
}
