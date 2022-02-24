package dp;

//web https://leetcode-cn.com/problems/unique-binary-search-trees/
public class uniqueBinarySearchTrees {
    private static class Solution {

        public Solution() {
        }

        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
//            dp[1] = 1;
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= i; ++j){
                    dp[i] += dp[j - 1] * dp[i - j];//左子树的可能乘以右子树的可能,左子树加上右子树的节点数量总和为i-1个
                }
            }
//            for (int val:dp) System.out.println(val);
            return dp[n];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int fib = solution.numTrees(5);
        System.out.println(fib);
    }
}
