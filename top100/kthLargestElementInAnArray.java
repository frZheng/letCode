package top100;

//web https://leetcode.cn/problems/kth-largest-element-in-an-array


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class   kthLargestElementInAnArray {
    private static class Solution {

        public Solution() {
        }


        public int findKthLargest(int[] nums, int k) {
            int res = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int num  : nums){
                pq.offer(num);
                if (pq.size() > k){
                    pq.poll();
                }
            }
            res = pq.peek();
            return res;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();

        int[] nums = {3,2,1,5,6,4};
        int k = 10;
        int s = solution.findKthLargest(nums, k);
        System.out.println(s);

    }
}
