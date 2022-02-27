package dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//web https://leetcode-cn.com/problems/word-break/
public class wordBreak {
    private static class Solution {

        public Solution() {
        }

        public boolean wordBreak(String s, List<String> wordDict) {
            int length = s.length();
            boolean[] dp = new boolean[length + 1];
            dp[0] = true;
            for (int i = 1; i <= length; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
//                String str = "";
//                for (int j = 0; j <= length; ++j) {
////                    System.out.println(dp[j]);
//                    str += dp[j];
//                    str += ",";
//                }
//                System.out.println(str);
            }
            return dp[length];
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean fib = solution.wordBreak(s, wordDict);
        System.out.println(fib);
    }
}
