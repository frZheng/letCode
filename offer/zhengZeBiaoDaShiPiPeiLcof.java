package offer;

//web https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof

import java.util.*;

public class zhengZeBiaoDaShiPiPeiLcof {
    private static class Solution {

        public Solution() {
        }


        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }



    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        String s = "abc";
        String p = "abc";
        boolean lists = solution.isMatch(s, p);
        System.out.println(lists);

    }

}
