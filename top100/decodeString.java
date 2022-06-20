package top100;

//web https://leetcode.cn/problems/decode-string


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class  decodeString {
    private static class Solution {
        String src;
        int ptr;
        public Solution() {
        }

        public String decodeString(String s) {
            src = s;
            ptr = 0;
            return getString();
        }
        public String getString() {
            if (ptr == src.length() || src.charAt(ptr) == ']') {
                // String -> EPS
                return "";
            }

            char cur = src.charAt(ptr);
            int repTime = 1;
            StringBuilder ret = new StringBuilder();

            if (Character.isDigit(cur)) {
                // String -> Digits [ String ] String
                // 解析 Digits
                repTime = getDigits();
                // 过滤左括号
                ++ptr;
                // 解析 String
                String str = getString();
                // 过滤右括号
                ++ptr;
                // 构造字符串
                while (repTime-- > 0) {
                    ret.append(str);
                }
            } else if (Character.isLetter(cur)) {
                // String -> Char String
                // 解析 Char
                ret = new StringBuilder(String.valueOf(src.charAt(ptr++)));
            }

            return ret + getString();
        }

        public int getDigits() {
            int ret = 0;
            while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
                ret = ret * 10 + src.charAt(ptr++) - '0';
            }
            return ret;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        String lists = solution.decodeString("3[a]2[bc]");
        System.out.println(lists);
    }
}
