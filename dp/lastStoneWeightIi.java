package dp;

//web https://leetcode-cn.com/problems/last-stone-weight-ii/
public class lastStoneWeightIi {
    private static class Solution {

        public Solution() {
        }

        public int lastStoneWeightII(int[] stones) {
//            int[] dp = new int[stones.length - 1];
            int len = stones.length;
            int sum = stones[0];
            for (int i = 1; i < len; ++i)
                sum += stones[i];
//            System.out.println(sum);
            int target = sum >> 1;
            int[] dp = new int[target + 1];

//            System.out.println(target + " " + len);
            for (int i = 0; i < len; ++i) {
                for (int j = target; j >= stones[i]; --j) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
//            for (int i = 0; i < target + 1; ++i)
//                System.out.println(dp[i]);
            return sum - (dp[target] + dp[target]);
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] stones ={2,7,4,1,8,1};
        int fib = solution.lastStoneWeightII(stones);
        System.out.println(fib);
    }
}
