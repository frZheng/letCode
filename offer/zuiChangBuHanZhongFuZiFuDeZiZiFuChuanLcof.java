package offer;

//web https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof

import java.util.*;

public class zuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    private static class Solution {

        public Solution() {
        }


        public int lengthOfLongestSubstring(String s) {
            int res = 0;
            Set<Character> set = new HashSet<>();
            for(int left = 0, right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                while(set.contains(c)) {
                    set.remove(s.charAt(left++));
                }
                set.add(c);
                res = Math.max(res, right - left + 1);
            }
            return res;
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
//        int num = 506;
        int lists = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(lists);

    }

}
