package top100;

//web https://leetcode-cn.com/problems/longest-substring-without-repeating-characters


import list.ListNode;

import java.util.ArrayList;
import java.util.HashSet;

public class longestSubstringWithoutRepeatingCharacters {
    private static class Solution {

        public Solution() {
        }
        public int lengthOfLongestSubstring(String s) {

            int[] last = new int[128];
            for(int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int n = s.length();

            int res = 0;
            int start = 0; // 窗口开始位置
            for(int i = 0; i < n; i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index] + 1);
                res   = Math.max(res, i - start + 1);
                last[index] = i;
            }

            return res;
        }

    }

    public static void main(String Args[]) {
        Solution solution = new Solution();
        int lists = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(lists);
    }

}
