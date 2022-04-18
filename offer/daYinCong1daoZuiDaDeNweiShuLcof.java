package offer;

//web https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof


import java.util.HashMap;

public class  daYinCong1daoZuiDaDeNweiShuLcof {
    private static class Solution {

        public Solution() {
        }
        public int[] printNumbers(int n) {

            int pow = (int)Math.pow(10, n) - 1;
//            System.out.println(pow);
            int[] ints = new int[pow];
            for (int i = 0; i < pow; ++i) {
                ints[i] = i + 1;
            }
            return ints;
        }
    }

    public static void main(String Args[]) {
        Solution solution = new Solution();

        int[] lists = solution.printNumbers(1);
        for (int i : lists)
            System.out.println(i);

    }



}
