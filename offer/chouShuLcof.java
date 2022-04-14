package offer;

 //web https://leetcode-cn.com/problems/chou-shu-lcof


import java.util.HashMap;

public class  chouShuLcof {
    private static class Solution {

        public Solution() {
        }
        public int nthUglyNumber(int n) {
//            int[] dp = new int[n + 1];
//            boolean[] isUgly = new boolean[n + 1];
//            for (int i = 0; i < n + 1; ++i) {
//                isUgly[i] = false;
//            }
//            if (n < 6) return n;
//            int result = 6;
//            for (int i = 1; i < 6; ++i) {
//                dp[i] = i ;
//                isUgly[i] = true;
//            }
//            for (int i = 6; i < n + 1; ++i) {
//                if ((i/2*2 ==i && isUgly[i/2]) ||
//                    (i/3*3 ==i && isUgly[i/3]) ||
//                    (i/5*5 ==i && isUgly[i/5])){
//                    isUgly[i] = true;
//                    result++;
//                }
//            }
//            return result;

//            int result = 0;
//            if (n < 6) return n;
//            HashMap<Integer, Boolean> isUgly = new HashMap<>();
//
//            for (int i = 1; i < 6; ++i) {
//                isUgly.put(i,true);
//                result++;
//            }
//            int i = 6;
//            while (result < n)
//            {
//                if ((i/2*2 ==i && isUgly.get(i/2)) ||
//                    (i/3*3 ==i && isUgly.get(i/3)) ||
//                    (i/5*5 ==i && isUgly.get(i/5))){
//                    isUgly.put(i,true);
//                    result++;
//                    System.out.println(result + ":" + i);
//                } else {
//                    isUgly.put(i,false);
//                }
//                i++;
//            }
//            return i - 1;

            if (n <= 0)
                return -1;
            int[] dp = new int[n];
            dp[0] = 1;
            int id2 = 0, id3 = 0, id5 = 0;
            for (int i = 1; i < n; i++) {
                dp[i] = Math.min(dp[id2] * 2, Math.min(dp[id3] *3, dp[id5] * 5));
                // 这里不用else if的原因是有可能id2(3) * 2 == id3(2) * 3
                // 这种情况两个指针都要后移
                if (dp[id2] * 2 == dp[i])
                    id2 += 1;
                if (dp[id3] * 3 == dp[i])
                    id3 += 1;
                if (dp[id5] * 5 == dp[i])
                    id5 += 1;
            }
            return dp[n - 1];
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        int lists = solution.nthUglyNumber(10);
        System.out.println(lists);

    }



}
