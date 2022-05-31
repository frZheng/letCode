package top100;

//web https://leetcode.cn/problems/perfect-squares


import java.util.*;

public class  perfectSquares {
    private static class Solution {

        public Solution() {
        }
        public int numSquares(int n) {
            ArrayList<Integer> squrares = new ArrayList<>();
            for (int i = 2; i <= 100; ++i){
                squrares.add(i*i);
            }
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

//        int[] lists = solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);

        int res = solution.numSquares(12);

        System.out.println(res);


    }
}
