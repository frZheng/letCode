package top100;

//web https://leetcode.cn/problems/subarray-sum-equals-k


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class   subarraySumEqualsK {
    private static class Solution {

        public Solution() {
        }



        public int subarraySum(int[] nums, int k) {
            int size = nums.length;
            int curSum = 0;
            int i =0;
            int sumNum = 0;
            int res = 0;
            while (i < size){
                if (curSum + nums[i] < k){
                    curSum += nums[i];
                    sumNum++;
                }
                else if (curSum + nums[i] == k){
                    res++;
                    curSum -= nums[i-sumNum];
                    curSum += nums[i];
                    sumNum--;
                }
                else {
                    while (i < size && curSum < k) {
                        curSum += nums[i];
                        sumNum++;
                        i++;
                    }
                }
                i++;
            }
            return res;
        }


    }


    public static void main(String[] Args) {
        Solution solution = new Solution();
        int[] nums={1,1,1};
        int k = 1;
        int s = solution.subarraySum(nums,k);
        System.out.println(s);

    }
}
