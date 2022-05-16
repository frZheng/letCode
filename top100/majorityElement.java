package top100;

//web https://leetcode.cn/problems/majority-element


import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class   majorityElement {
    private static class Solution {

        public Solution() {
        }


        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int res = 0;
            int maxLen = 0;

//            int halfSize = (nums.length+1)/2;
            for (int i= 0; i < nums.length; ++i) {
                Integer num = map.getOrDefault(nums[i], 0);
                num = num + 1;
//                if (num >= halfSize)
//                    return nums[i];
                if (maxLen < num){
                    maxLen = num;
                    res = nums[i];
                }
                map.put(nums[i],num);
            }
            return res;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();


        int s = solution.majorityElement(new int[] {3,2,3});
        System.out.println(s);

    }
}
