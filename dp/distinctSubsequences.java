package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

//web https://leetcode-cn.com/problems/distinct-subsequences
public class distinctSubsequences {
    private static class Solution {

        public Solution() {
        }

        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i < s.length() + 1; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i < s.length() + 1; i++) {
                for (int j = 1; j < t.length() + 1; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[s.length()][t.length()];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String string = "rabbbit";
        String subString = "rabbit";
        int fib = solution.numDistinct(string, subString);
        System.out.println(fib);
    }
}
