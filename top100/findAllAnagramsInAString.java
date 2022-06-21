package top100;

//web https://leetcode.cn/problems/find-all-anagrams-in-a-string


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class   findAllAnagramsInAString {
    private static class Solution {

        public Solution() {
        }

        public List<Integer> findAnagrams(String s, String p) {
            
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        List<Integer> lists = solution.findAnagrams("cbaebabacd", "abc");
        for (int i :lists)
            System.out.println(i);

    }
}
