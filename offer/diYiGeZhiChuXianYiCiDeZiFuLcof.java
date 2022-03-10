package offer;

//web https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof

import java.util.HashMap;

public class diYiGeZhiChuXianYiCiDeZiFuLcof {
    private static class Solution {

        public Solution() {
        }
//        public char firstUniqChar(String s) {
//            char[] res = {' '};
//            while(s.length() > 0){
//                String substring = s.substring(0, 1);
//                if (s.substring(1).contains(substring))
//                    s = s.replace(substring, "");
//                else {
//                    substring.getChars(0, 0 + 1, res, 0);
//                    return res[0];
//                }
//            }
//            return ' ';
//        }
        public char firstUniqChar(String s) {
            int[] ints = new int[26];
            int len = s.length();
            for (int i = 0; i < len; ++i){
                ints[s.charAt(i) - 'a'] ++;
            }
            for (int i = 0; i < len; ++i){
                if (ints[s.charAt(i) - 'a'] == 1) return s.charAt(i);
            }
            return ' ';
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        char s = solution.firstUniqChar("");
        System.out.println("res: " + s);

    }
		
}
