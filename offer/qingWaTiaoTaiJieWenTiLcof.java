package offer;

 //web https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof

public class qingWaTiaoTaiJieWenTiLcof {
    private static class Solution {

        public Solution() {
        }

        public int numWays(int n) {
            int[] dp = new int[2];
            dp[0] = 1;
            dp[1] = 1;
            if (n < 2) return dp[n];
            int sum = 0;
            for (int i = 2; i <= n; ++i) {
                sum = dp[1] + dp[0];
                if (sum >= 1000000007)
                    sum -= 1000000007;
                dp[0] = dp[1];
                dp[1] = sum;
            }
            return sum;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();

        int lists = solution.numWays(7);
        System.out.println(lists);

    }

}
