package top100;

//web https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array


import list.ListNode;

import java.util.*;

public class findAllNumbersDisappearedInAnArray {
    private static class Solution {

        public Solution() {
        }
        public List<Integer> findDisappearedNumbers(int[] nums) {
//            int maxVal = nums.length;
////            int size = nums.length;
//            for (int j : nums) {
//                maxVal = Math.max(j, maxVal);
//            }
//
//            ArrayList<Integer> res = new ArrayList<>();
//            int[] ints = new int[maxVal];
//            for (int num : nums) {
//                ints[num - 1] = 1;
//            }
//            for (int i = 0; i < maxVal; ++i) {
//                if(ints[i]==0) {
//                    res.add(i+1);
//                }
//            }
//            return res;

            int n = nums.length;
            for (int num : nums) {
                int x = (num - 1) % n;
                nums[x] += n;
            }
            List<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) {
                    ret.add(i + 1);
                }
            }
            return ret;

        }

    }



    public static void main(String Args[]) {
        Solution solution = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = solution.findDisappearedNumbers(nums);
        for (int i : res){
            System.out.println(res);
        }
    }

}
