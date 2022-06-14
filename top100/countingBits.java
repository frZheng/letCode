package top100;

//web https://leetcode.cn/problems/counting-bits


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class  countingBits {
    private static class Solution {

        public Solution() {
        }

        public int[] countBits(int n) {
            int[] res = new int[n+1];
            for (int i = 1; i <= n; i++) {
                res[i] = res[i & (i - 1)] + 1;
            }
            return res;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int[] lists = solution.countBits(5);
        for (int i : lists)
            System.out.println(i);
    }
}
