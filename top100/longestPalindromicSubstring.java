package top100;

//web https://leetcode-cn.com/problems/longest-palindromic-substring


import list.ListNode;

import java.util.ArrayList;
import java.util.HashSet;

public class  longestPalindromicSubstring {
    private static class Solution {

        public Solution() {
        }
        public String longestPalindrome(String s) {
            int maxLen = 1;
            String result=s.substring(0,1);
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == s.charAt(i-1) && maxLen < 2) {
                    maxLen = 2;
                    result = s.substring(i - 1, i + 1);
                }
                int minFind = Math.min(i,s.length()-i-1);
                for (int j = 1; j <= minFind; ++j) {
                    if (s.charAt(i-j) == s.charAt(i+j)) {
                        int len = j*2+1;
                        if (len > maxLen) {
                            result = s.substring(i - j, i + j + 1);
                            maxLen = len;
                        }
                    }
                }
            }
            return result;
        }

    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        String lists = solution.longestPalindrome("aaaa");
        System.out.println(lists);
    }

}
