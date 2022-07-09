package top100;

//web https://leetcode.cn/problems/subarray-sum-equals-k


import java.util.*;

public class   subarraySumEqualsK {
    private static class Solution {

        public Solution() {
        }


        public int subarraySum(int[] nums, int k) {
            int count = 0, pre = 0;
            HashMap< Integer, Integer > mp = new HashMap < > ();
            mp.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }

    }


    public static void main(String[] Args) {
        Solution solution = new Solution();
//        int[] nums={1,2,1,2,1};
//        int k = 3;
        int[] nums={-1,-1,1};
        int k = 0;
        int s = solution.subarraySum(nums,k);
        System.out.println(s);

    }
}
