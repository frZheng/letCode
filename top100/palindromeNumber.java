package top100;

//web https://leetcode-cn.com/problems/palindrome-number


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class   palindromeNumber {
    private static class Solution {

        public Solution() {
        }


        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            String s = String.valueOf(x);
            for (int i=0,j=s.length()-1;i <= j;++i,--j){
                if(s.charAt(i) != s.charAt(j))
                    return false;
            }
            return true;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        Boolean s = solution.isPalindrome(2122);
        System.out.println(s);

    }
}
