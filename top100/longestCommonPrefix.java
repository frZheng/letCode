package top100;

//web https://leetcode-cn.com/problems/longest-common-prefix


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class   longestCommonPrefix {
    private static class Solution {

        public Solution() {
        }


        public String longestCommonPrefix(String[] strs) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strs[0].length(); ++i) {
                char ch = strs[0].charAt(i);
                for (int j =1 ; j < strs.length; ++j) {

                    if (strs[j].length() <= i || ch != strs[j].charAt(i)) {
                        return stringBuilder.toString();
                    }
                }
                stringBuilder.append(ch);
            }
            return stringBuilder.toString();
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        String[] strs = {"flower","dflow","flight"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);

    }
}
