package offer;

//web https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class zuiXiaoDeKgeShuLcof {
    private static class Solution {

        public Solution() {
        }


        public int[] getLeastNumbers(int[] arr, int k) {
//            if (k == 0) return new int[0];
            int[] res = new int[k];
            if (k == 0) return res;
            int max_index = 0;
//            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; ++i) {
                res[i] = arr[i];
                if(arr[i] > res[max_index])
                    max_index = i;
            }
            for (int i = k; i < arr.length;++i) {
                if (arr[i] < res[max_index]){
                    res[max_index] = arr[i];
                    max_index = 0;
                    for (int j = 1; j < k;++j) {
                        if(res[j] > res[max_index])
                            max_index = j;
                    }
                }
            }
            return res;
        }
    }
    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] num = {0,0,1,2,4,2,2,3,1,4};
        int[] lists = solution.getLeastNumbers(num, 0);
        for (int i : lists)
            System.out.println(i);

    }

}
