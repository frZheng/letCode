package top100;

//web https://leetcode.cn/problems/palindromic-substrings


import java.util.*;

public class   palindromicSubstrings {
    private static class Solution {

        public Solution() {
        }

//        boolean ispalindrom(String s) {
//            int size = s.length();
//            int halfSize = size/2;
//            for (int i = 0; i < halfSize; i++) {
//                if (s.charAt(i) != s.charAt(size-1-i))
//                    return false;
//            }
//            return true;
//        }
//        public int countSubstrings(String s) {
//            int size = s.length();
//            int res = size;
//            for (int i = 1; i < size; ++i) {
//                for (int j = 0; j < size-i; ++j){
//                    String substring = s.substring(j, j + i+1);
//                    boolean bool = ispalindrom(substring);
////                    System.out.println(substring + " " +bool);
//                    if (bool) {
//                        res++;
//                    }
//                }
//            }
//            return res;
//        }


        public int countSubstrings(String s) {
            int n = s.length();
            StringBuilder t = new StringBuilder("$#");
            for (int i = 0; i < n; ++i) {
                t.append(s.charAt(i));
                t.append('#');
            }
            n = t.length();
            t.append('!');

            int[] f = new int[n];
            int iMax = 0, rMax = 0, ans = 0;
            for (int i = 1; i < n; ++i) {
                // 初始化 f[i]
                f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
                // 中心拓展
                while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                    ++f[i];
                }
                // 动态维护 iMax 和 rMax
                if (i + f[i] - 1 > rMax) {
                    iMax = i;
                    rMax = i + f[i] - 1;
                }
                // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
                ans += f[i] / 2;
            }

            return ans;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();
        int s = solution.countSubstrings("aaa");
//        boolean s = solution.ispalindrom("ab");
        System.out.println(s);

    }
}
