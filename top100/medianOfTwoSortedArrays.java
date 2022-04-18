package top100;

//web https://leetcode-cn.com/problems/median-of-two-sorted-arrays


import list.ListNode;

import java.util.ArrayList;
import java.util.HashSet;

public class  medianOfTwoSortedArrays {
    private static class Solution {

        public Solution() {
        }
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length == 0 && nums2.length == 1) return nums2[0];
            if(nums2.length == 0 && nums1.length == 1) return nums1[0];
            int[] res = new int[nums1.length + nums2.length];

            int p1 = nums1.length - 1,p2 = nums2.length - 1;

            for(int i = res.length-1;i >= res.length/2-1;i--){
                if(p1 == -1){
                    res[i] = nums2[p2--];
                    continue;
                }
                if(p2 == -1){
                    res[i] = nums1[p1--];
                    continue;
                }
                if(nums1[p1] >= nums2[p2]){
                    res[i] = nums1[p1];
                    p1--;
                }
                else{
                    res[i] = nums2[p2];
                    p2--;
                }
            }
            if(res.length % 2 == 1) return res[res.length/2];
            return (res[res.length/2] + res[res.length/2 - 1])/2.0;
        }

    }

    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        double lists = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(lists);
    }

}
