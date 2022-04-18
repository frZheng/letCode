package offer;

//web https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class  shuZiXuLieZhongMouYiWeiDeShuZiLcof {
    private static class Solution {

        public Solution() {
        }

        public int findNthDigit(int n) {
            int digit = 1;   // n所在数字的位数
            long start = 1;  // 数字范围开始的第一个数
            long count = 9;  // 占多少位
            while(n > count){
                n -= count;
                digit++;
                start *= 10;
                count = digit * start * 9;
            }
            long num = start + (n - 1) / digit;
            return Long.toString(num).charAt((n - 1) % digit) - '0';
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();

        int lists = solution.findNthDigit(10);
        System.out.println(lists);

    }

}
