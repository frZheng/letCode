package dp;

 //web https://leetcode-cn.com/problems/is-subsequence
public class isSubsequence {
    private static class Solution {

        public Solution() {
        }

        public boolean isSubsequence(String s, String t) {
//            int index = -1;
//            for (char c : s.toCharArray()){
//                index = t.indexOf(c, index+1);
//                if (index == -1) return false;
//            }
//            return true;
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = dp[i][j - 1];
                }
            }

            if (dp[s.length()][t.length()] == s.length()) return true;
            return false;
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String string = "ahbgdc";
        String subString = "axc";
        boolean fib = solution.isSubsequence(subString, string);
        System.out.println(fib);
    }
}
