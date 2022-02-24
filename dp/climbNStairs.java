package dp;

//web
// 完全背包问题
// ⼀步⼀个台阶，两个台阶，三个台阶，直到 m个台阶，有多少种⽅法爬到n阶楼顶。
public class climbNStairs {
    private static class Solution {

        public Solution() {
        }
        // MaxClimNum 最多爬MaxClimNum
        public int fib(int n, int MaxClimNum) {
            if (n <= 1) return n;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 0; i <= n; ++i) {
                for (int j = 0; j <= MaxClimNum; ++j) {
                    if(i - j >= 0)
                        dp[i] += dp[i-j];
                }
            }
            return dp[n];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int fib = solution.fib(3,2);
        System.out.println(fib);
    }
}
