package top100;

//web https://leetcode.cn/problems/hamming-distance


import list.ListNode;

import java.util.*;

public class hammingDistance {
    private static class Solution {

        public Solution() {
        }
        public int hammingDistance(int x, int y) {
            int res = 0;
            int z = x^y;
            while (z>0){
                if((z & 0x01)==0x01) {
                    res++;
                }
                z = z>>1;
            }
            return res;
        }

    }



    public static void main(String Args[]) {
        Solution solution = new Solution();
        int res = solution.hammingDistance(1,4);
        System.out.println(res);
    }

}
