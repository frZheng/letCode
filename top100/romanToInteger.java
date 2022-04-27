package top100;

//web https://leetcode-cn.com/problems/roman-to-integer


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class   romanToInteger {
    private static class Solution {

        public Solution() {
        }


        public int romanToInt(String s) {
            int res = 0;
//            HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
//            stringIntegerHashMap.put()
            int len = s.length();
            for (int i = 0; i < s.length(); ) {
                if (s.charAt(i) == 'M') {
                    res += 1000;
                    ++i;
                } else if (i + 1 < len && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i += 2;
                } else if (s.charAt(i) == 'D') {
                    res += 500;
                    ++i;
                } else if (i + 1 < len && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                    res += 400;
                    i += 2;
                } else if (s.charAt(i) == 'C') {
                    res += 100;
                    ++i;
                } else if (i + 1 < len && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i += 2;
                } else if (s.charAt(i) == 'L') {
                    res += 50;
                    ++i;
                } else if (i + 1 < len && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i += 2;
                } else if (s.charAt(i) == 'X') {
                    res += 10;
                    ++i;
                } else if (i + 1 < len && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i += 2;
                } else if (s.charAt(i) == 'V') {
                    res += 5;
                    ++i;
                } else if (i + 1 < len && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i += 2;
                } else if (s.charAt(i) == 'I') {
                    res += 1;
                    ++i;
                }

            }

            return res;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int s = solution.romanToInt("MCMXCIV");
        System.out.println(s);

    }
}
