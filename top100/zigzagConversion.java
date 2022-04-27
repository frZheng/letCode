package top100;

//web https://leetcode-cn.com/problems/zigzag-conversion


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class  zigzagConversion {
    private static class Solution {

        public Solution() {
        }


        public String convert(String s, int numRows) {
            int n = s.length(), r = numRows;
            if (r == 1 || r >= n) {
                return s;
            }
            StringBuffer[] mat = new StringBuffer[r];
            for (int i = 0; i < r; ++i) {
                mat[i] = new StringBuffer();
            }
            for (int i = 0, x = 0, t = r * 2 - 2; i < n; ++i) {
                mat[x].append(s.charAt(i));
                if (i % t < r - 1) {
                    ++x;
                } else {
                    --x;
                }
            }
            StringBuffer ans = new StringBuffer();
            for (StringBuffer row : mat) {
                ans.append(row);
            }
            return ans.toString();
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        String s = solution.convert("PAYPALISHIRING",3);
        System.out.println(s);

    }
}
