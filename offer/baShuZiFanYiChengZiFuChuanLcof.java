package offer;

//web https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class baShuZiFanYiChengZiFuChuanLcof {
    private static class Solution {

        public Solution() {
        }


        public int translateNum(int num) {

//            System.out.println(num);
            ArrayList<Integer> stack = new ArrayList<>();
            if (num < 1) return 1;
            while (num > 0) {
                stack.add(num % 10);
                num = num / 10;
            }
            int size =stack.size();
            int last = stack.get(size - 1);
            int[] dp = new int[2];
            int cur;
            int tmp;
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1; i < size; ++i){
                cur = stack.get(size - i - 1);
                int index = cur + last*10;

                // 只有 10-26之间的才会有结果
                if (index<26 && index>9) {
                    tmp = dp[0] + dp[1];
                }
                else
                    tmp = dp[1];

                dp[0] = dp[1];
                dp[1] = tmp;
                last = cur;
//                System.out.println(cur + " " + index + " " + dp[1]);
            }
            return dp[1];
        }
//        public int translateNum(int num) {
//            if (num <= 9) return 1;
//            int ba = num%100;
//            if (ba <= 9 || ba >= 26) return translateNum(num/10);
//            return translateNum(num/10) + translateNum(num/100);
//        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int num = 506;
        int lists = solution.translateNum(num);
        System.out.println(lists);

    }

}
