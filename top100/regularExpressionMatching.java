package top100;

//web https://leetcode-cn.com/problems/regular-expression-matching


import list.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class  regularExpressionMatching {
    private static class Solution {

        public Solution() {
        }

        public boolean isMatch(String s, String p) {
            int sLen = s.length(), pLen = p.length();
            boolean[][] memory = new boolean[2][pLen+1];
            memory[0][0] = true;
            int cur = 0, pre = 0;
            for(int i = 0; i <= sLen; i++) {
                cur = i % 2;
                pre = (i + 1) % 2;
                if(i > 1) {
                    for(int j = 0; j <= pLen; j++) {
                        memory[cur][j] = false;
                    }
                }
                for(int j = 1; j <= pLen; j++) {
                    if(p.charAt(j-1) == '*') {

                        memory[cur][j] = memory[cur][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) ||
                                p.charAt(j-2) == '.') && memory[pre][j]);
                    }else {
                        memory[cur][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                                && memory[pre][j-1];
                    }
                }
            }
            return memory[cur][pLen];
        }
    }



    public static void main(String Args[]) {
        Solution solution = new Solution();


        boolean lists = solution.isMatch("aaaa","a*");
        System.out.println(lists);
    }

}
