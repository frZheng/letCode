package top100;

//web https://leetcode-cn.com/problems/string-to-integer-atoi


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class   stringToIntegerAtoi {
    private static class Solution {

        public Solution() {
        }


        public int myAtoi(String s) {
            long res = 0;
            boolean startFlage =false;
            int sign = 1;
            for (int i = 0; i < s.length(); ++i){
                char ch = s.charAt(i);

                if (!startFlage && ch == ' ')
                    continue;
                if (startFlage && (ch < '0' || ch >'9'))
                    return (int)Math.min(Integer.MAX_VALUE,res) * sign;
                if (!startFlage && (ch <= '9' && ch >= '0')) {
                    startFlage = true;
                    res += ch - '0';
                    continue;
                }
                if (!startFlage && ch =='+') {
                    startFlage = true;
                    sign = 1;
                    continue;
                }
                if (!startFlage && ch =='-') {
                    startFlage = true;
                    sign = -1;
                    continue;
                }
                if (!startFlage)
                    return 0;
                res = res * 10 + ch - '0';
                if (res*sign >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if(res*sign <= Integer.MIN_VALUE ) {
                    return Integer.MIN_VALUE;
                }

            }

            return (int)Math.min(Integer.MAX_VALUE, res) * sign;
//            res = res * sign;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        int s = solution.myAtoi("-2147483648");
        System.out.println(s);

    }
}
