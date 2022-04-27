package top100;

//web https://leetcode-cn.com/problems/reverse-integer


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class  reverseInteger {
    private static class Solution {

        public Solution() {
        }


        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }




    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        int s = solution.reverse(1534236469);
        System.out.println(s);

    }
}
