package offer;

//web https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof





public class feiBoNaQiShuLieLcof {
    private static class Solution {

        public Solution() {
        }
        public int fib(int n) {
            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = 1;
            if (n < 2) return dp[n];
            int sum = 0;
            for (int i = 2; i <= n; ++i) {
                sum = dp[0] + dp[1];
                if (sum >= 1000000007) {
                    sum -= 1000000007;
                }
                dp[0] = dp[1];
                dp[1] = sum;

            }
            return sum;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        int lists = solution.fib(45);
        System.out.println(lists);

//        System.out.println("result");
//        for (int i : ints)
//            System.out.println(i);
    }



}
