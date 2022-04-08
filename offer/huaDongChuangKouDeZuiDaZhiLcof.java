package offer;

//web https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class huaDongChuangKouDeZuiDaZhiLcof {
    private static class Solution {

        public Solution() {
        }
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k < 2) return nums;
            int[] result = new int[nums.length - k + 1];

            for (int i = 0; i < nums.length - k + 1; ++i) {
                int maxVal = Integer.MIN_VALUE;
                for (int j = 0; j < k; ++j) {
                    maxVal = Math.max(maxVal, nums[i + j]);
                }
                result[i] = maxVal;
            }
            return result;
        }

    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] num = {1,3,-1,-3,5,3,6,7};
        int[] lists = solution.maxSlidingWindow(num,3);
        for (int l : lists)
            System.out.println(l);

    }

}
